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

public class teacherAdapter extends ArrayAdapter<Teacher> {

    public teacherAdapter(@NonNull Context context, @NonNull List<Teacher> teachers) {
        super(context, 0, teachers);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_teacher, parent, false);
        }

        Teacher teacher = getItem(position);

        TextView name = convertView.findViewById(R.id.teacher_name);
        TextView email = convertView.findViewById(R.id.teacher_email);
        TextView deptId = convertView.findViewById(R.id.teacher_dept_id);

        name.setText("Name: " + teacher.getTeacherName());
        email.setText("Email: " + teacher.getEmail());
        deptId.setText("Dept ID: " + teacher.getDeptId());

        return convertView;
    }
}


