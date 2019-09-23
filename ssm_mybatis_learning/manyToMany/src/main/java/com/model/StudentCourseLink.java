package com.model;

import java.util.Date;

public class StudentCourseLink {
    private Student student;
    private Courses courses;
    private Date date;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "StudentCourseLink{" +
                "student=" + student +
                ", courses=" + courses +
                ", date=" + date +
                '}';
    }
}
