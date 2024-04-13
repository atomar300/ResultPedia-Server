package com.ashishtomar.resultpedia.dto;


import jakarta.validation.constraints.NotEmpty;

public class ResultDTO {

    @NotEmpty
    private String studentId;

    @NotEmpty
    private String courseId;

    @NotEmpty
    private String grade;


    public ResultDTO(String studentId, String courseId, String grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
