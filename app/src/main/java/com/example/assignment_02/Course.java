package com.example.assignment_02;

public class Course {
    private int course_id;
    private String course_name;
    private int credit_hours;
    private int teacher_id;
    private int dept_id;

    public Course(int course_id, String course_name, int credit_hours, int teacher_id, int dept_id) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.credit_hours = credit_hours;
        this.teacher_id = teacher_id;
        this.dept_id = dept_id;
    }

    public int getCourseId() {
        return course_id;
    }

    public String getCourseName() {
        return course_name;
    }

    public int getCreditHours() {
        return credit_hours;
    }

    public int getTeacherId() {
        return teacher_id;
    }

    public int getDeptId() {
        return dept_id;
    }
}

