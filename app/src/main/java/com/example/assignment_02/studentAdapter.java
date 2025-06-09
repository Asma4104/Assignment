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

public class studentAdapter extends ArrayAdapter<Student> {

    public studentAdapter(@NonNull Context context, @NonNull List<Student> students) {
        super(context, 0, students);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_student, parent, false);
        }

        Student student = getItem(position);

        TextView name = convertView.findViewById(R.id.student_name);
        TextView email = convertView.findViewById(R.id.student_email);
        TextView deptId = convertView.findViewById(R.id.student_dept_id);

        name.setText("Name: " + student.getStudentName());
        email.setText("Email: " + student.getEmail());
        deptId.setText("Dept ID: " + student.getDeptId());

        return convertView;
    }
}
