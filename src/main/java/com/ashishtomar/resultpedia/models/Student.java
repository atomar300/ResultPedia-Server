package com.ashishtomar.resultpedia.models;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document (collection = "students")
public class Student {

    @Id
    private String id;

    @NotNull
    private int studentNumber;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String familyName;

    // I created my own annotation named 'CustomAgeAnnotation' to check if the student is at least 10 years
    @CustomAgeAnnotation
    @Past
    @NotNull
    public LocalDate birthDate;





    public Student(int studentNumber, String firstName, String familyName, LocalDate birthDate){
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.familyName = familyName;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStudentNumber(){
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber){
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
