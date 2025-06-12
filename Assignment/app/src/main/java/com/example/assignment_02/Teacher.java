package com.example.assignment_02;

public class Teacher {
    private int teacher_id;
    private String teacher_name;
    private String email;
    private int dept_id;

    public Teacher(int teacher_id, String teacher_name, String email, int dept_id) {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.email = email;
        this.dept_id = dept_id;
    }

    public int getTeacherId() {
        return teacher_id;
    }

    public String getTeacherName() {
        return teacher_name;
    }

    public String getEmail() {
        return email;
    }

    public int getDeptId() {
        return dept_id;
    }
}

