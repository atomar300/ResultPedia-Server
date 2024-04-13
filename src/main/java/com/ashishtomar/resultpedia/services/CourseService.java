package com.ashishtomar.resultpedia.services;

import com.ashishtomar.resultpedia.exceptions.CourseNotFoundException;
import com.ashishtomar.resultpedia.models.Course;
import com.ashishtomar.resultpedia.models.Result;
import com.ashishtomar.resultpedia.models.Student;
import com.ashishtomar.resultpedia.repositories.CourseRepository;
import com.ashishtomar.resultpedia.repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ResultRepository resultRepository;


    @Override
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }



    @Override
    public Course createCourse(Course course){
        return courseRepository.save(course);
    }


    @Override
    public Course getCourse(String id){
        Optional<Course> courseData = courseRepository.findById(id);
        if (courseData.isEmpty()){
            throw new CourseNotFoundException("No course was found with the given ID: "+id);
        }
        return courseData.get();
    }


    @Override
    public Course updateCourse(String id, Course course){
        Optional<Course> courseData = courseRepository.findById(id);
        if (courseData.isEmpty()){
            throw new CourseNotFoundException("No course was found with the given ID: "+id);
        }
        course.setId(id);
        return courseRepository.save(course);
    }


    @Override
    public void deleteCourse(String id){
        Optional<Course> courseData = courseRepository.findById(id);
        if (courseData.isEmpty()){
            throw new CourseNotFoundException("No course was found with the given ID: "+id);
        }
        Course course = courseData.get();
        List<Result> results = resultRepository.findByCourse(course);
        resultRepository.deleteAll(results);
        courseRepository.deleteById(id);
    }

}
