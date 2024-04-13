package com.ashishtomar.resultpedia.services;

import com.ashishtomar.resultpedia.models.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getAllStudents();
    Student createStudent(Student student);

    Student getSingleStudent(String id);

    Student updateStudent(String id, Student student);

    void deleteStudent(String id);

}
