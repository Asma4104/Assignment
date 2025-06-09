package com.example.assignment_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.List;

public class DepartmentAdapter extends ArrayAdapter<Department> {
    private Context context;
    private List<Department> departments;

    public DepartmentAdapter(Context context, List<Department> departments) {
        super(context, 0, departments);
        this.context = context;
        this.departments = departments;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.department_item, parent, false);

        TextView idText = convertView.findViewById(R.id.departmentId);
        TextView nameText = convertView.findViewById(R.id.departmentname);

        Department dept = departments.get(position);

        idText.setText(String.valueOf(dept.getDeptId()));  // Set department ID
        nameText.setText(dept.getDeptName());              // Set department name

        return convertView;
    }

}



