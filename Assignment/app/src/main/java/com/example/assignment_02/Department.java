package com.example.assignment_02;

public class Department {
    private int dept_id;
    private String deptName;

    public Department(int dept_id, String dept_name) {
        this.dept_id = dept_id;
        this.deptName = dept_name;
    }

    public String getDeptName() {
        return deptName;
    }
    public int getDeptId() {
        return dept_id;
    }
}


