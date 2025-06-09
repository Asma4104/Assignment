package com.example.assignment_02;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class DepartmentFragment extends Fragment {

    ListView listView;
    List<Department> departmentList;
    DepartmentAdapter adapter;

    String url = "https://studious-umbrella-7vwqpjww6pp9cxpwq-8090.app.github.dev/department"; // Replace with your actual deployed URL

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_department, container, false);

        listView = view.findViewById(R.id.listViewDepartments);
        departmentList = new ArrayList<>();

        adapter = new DepartmentAdapter(getContext(), departmentList);
        listView.setAdapter(adapter);

        loadDepartments();

        return view;
    }

    private void loadDepartments() {
        RequestQueue queue = Volley.newRequestQueue(getContext());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    departmentList.clear();
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject obj = response.getJSONObject(i);
                            int deptId = obj.getInt("dept_id");
                            String deptName = obj.getString("dept_name");
                            departmentList.add(new Department(deptId, deptName));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    adapter.notifyDataSetChanged();
                },
                error -> {
                    Toast.makeText(getContext(), "Failed to load departments", Toast.LENGTH_SHORT).show();
                    Log.e("VolleyError", error.toString());
                });

        queue.add(jsonArrayRequest);
    }
}
