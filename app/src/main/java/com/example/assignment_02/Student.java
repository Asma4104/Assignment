package com.example.assignment_02;


public class Student {
    private int student_id;
    private String student_name;
    private String email;
    private int dept_id;

    public Student(int student_id, String student_name, String email, int dept_id) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.email = email;
        this.dept_id = dept_id;
    }

    public int getStudentId() {
        return student_id;
    }

    public String getStudentName() {
        return student_name;
    }

    public String getEmail() {
        return email;
    }

    public int getDeptId() {
        return dept_id;
    }
}

