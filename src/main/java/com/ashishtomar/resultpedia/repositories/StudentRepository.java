package com.ashishtomar.resultpedia.repositories;


import com.ashishtomar.resultpedia.models.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    Boolean existsByStudentNumber(int studentNumber);

}
