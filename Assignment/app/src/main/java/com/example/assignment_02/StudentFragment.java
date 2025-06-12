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

public class StudentFragment extends Fragment {

    ListView listView;
    List<Student> studentList;
    studentAdapter adapter;

    String url = "https://studious-umbrella-7vwqpjww6pp9cxpwq-8090.app.github.dev/student";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_student, container, false);

        listView = view.findViewById(R.id.listViewStudents);
        studentList = new ArrayList<>();

        adapter = new studentAdapter(getContext(), studentList);
        listView.setAdapter(adapter);

        loadStudents();

        return view;
    }

    private void loadStudents() {
        RequestQueue queue = Volley.newRequestQueue(getContext());

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    studentList.clear();
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject obj = response.getJSONObject(i);
                            int id = obj.getInt("student_id");
                            String name = obj.getString("student_name");
                            String email = obj.getString("email");
                            int deptId = obj.getInt("dept_id");
                            studentList.add(new Student(id, name, email, deptId));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    adapter.notifyDataSetChanged();
                },
                error -> {
                    Toast.makeText(getContext(), "Failed to load students", Toast.LENGTH_SHORT).show();
                    Log.e("VolleyError", error.toString());
                });

        queue.add(request);
    }
}
