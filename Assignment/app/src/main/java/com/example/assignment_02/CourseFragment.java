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

public class CourseFragment extends Fragment {

    ListView listView;
    List<Course> courseList;
    CourseAdapter adapter;

    String url = "https://studious-umbrella-7vwqpjww6pp9cxpwq-8090.app.github.dev/course";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_course, container, false);

        listView = view.findViewById(R.id.listViewCourses);
        courseList = new ArrayList<>();

        adapter = new CourseAdapter(getContext(), courseList);
        listView.setAdapter(adapter);

        loadCourses();

        return view;
    }

    private void loadCourses() {
        RequestQueue queue = Volley.newRequestQueue(getContext());

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    courseList.clear();
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject obj = response.getJSONObject(i);
                            int id = obj.getInt("course_id");
                            String name = obj.getString("course_name");
                            int hours = obj.getInt("credit_hours");
                            int teacherId = obj.getInt("teacher_id");
                            int deptId = obj.getInt("dept_id");
                            courseList.add(new Course(id, name, hours, teacherId, deptId));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    adapter.notifyDataSetChanged();
                },
                error -> {
                    Toast.makeText(getContext(), "Failed to load courses", Toast.LENGTH_SHORT).show();
                    Log.e("VolleyError", error.toString());
                });

        queue.add(request);
    }
}
