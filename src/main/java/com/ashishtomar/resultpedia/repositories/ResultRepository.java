package com.ashishtomar.resultpedia.repositories;


import com.ashishtomar.resultpedia.models.Course;
import com.ashishtomar.resultpedia.models.Result;
import com.ashishtomar.resultpedia.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends MongoRepository<Result, String> {

    List<Result> findByCourse(Course course);

    List<Result> findByStudent(Student student);

    boolean existsByStudentAndCourse(Student student, Course course);

    Result findByStudentAndCourse(Student student, Course course);
}
