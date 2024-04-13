package com.ashishtomar.resultpedia.models;


import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
public class Course {

    @Id
    private String id;

    @NotEmpty
    private String courseName;

    @NotEmpty
    private String courseCode;

    private double courseAverage;




    public Course(String courseName, String courseCode){
        this.courseName = courseName;
        this.courseCode = courseCode;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getCourseAverage() {
        return courseAverage;
    }

    public void setCourseAverage(double courseAverage) {
        this.courseAverage = courseAverage;
    }
}
