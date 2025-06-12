package com.example.assignment_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CourseAdapter extends ArrayAdapter<Course> {

    public CourseAdapter(@NonNull Context context, @NonNull List<Course> courses) {
        super(context, 0, courses);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_course, parent, false);
        }

        Course course = getItem(position);

        TextView courseId = convertView.findViewById(R.id.course_teacher_id);
        TextView courseName = convertView.findViewById(R.id.course_name);
        TextView courseCredit = convertView.findViewById(R.id.course_credit);
        TextView deptId = convertView.findViewById(R.id.course_dept_id);

        courseId.setText("Course ID: " + course.getCourseId());
        courseName.setText("Name: " + course.getCourseName());
        courseCredit.setText("Credit hour: "+ course.getCreditHours());
        deptId.setText("Dept ID: " + course.getDeptId());

        return convertView;
    }
}
