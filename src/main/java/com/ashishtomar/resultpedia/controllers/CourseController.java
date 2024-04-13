package com.ashishtomar.resultpedia.controllers;


import com.ashishtomar.resultpedia.models.Course;
import com.ashishtomar.resultpedia.models.Student;
import com.ashishtomar.resultpedia.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;


    @PostMapping("/course/add")
    public ResponseEntity<String> createCourse(@Valid @RequestBody Course course) {

        courseService.createCourse(course);

        return new ResponseEntity<>("Course was added successfully!", HttpStatus.OK);
    }




    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses(){

        List<Course> courses = courseService.getAllCourses();

        return new ResponseEntity<>(courses, HttpStatus.OK);
    }




    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getOneCourse(@PathVariable("id") String id){

        Course course = courseService.getCourse(id);

        return new ResponseEntity<>(course, HttpStatus.OK);
    }



    @PutMapping("/course/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable("id") String id, @Valid @RequestBody Course course){

        courseService.updateCourse(id, course);

        return new ResponseEntity<>("Course Updated Successfully!", HttpStatus.OK);
    }




    @DeleteMapping("/course/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") String id){

        courseService.deleteCourse(id);

        return new ResponseEntity<>("Course Deleted Successfully!", HttpStatus.OK);
    }

}
