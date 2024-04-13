package com.ashishtomar.resultpedia.repositories;

import com.ashishtomar.resultpedia.models.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
}
