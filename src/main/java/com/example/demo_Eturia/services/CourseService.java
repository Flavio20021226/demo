package com.example.demo_Eturia.services;

import com.example.demo_Eturia.entities.Course;
import com.example.demo_Eturia.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> updateCourse(Long id, Course updatedCourse) {
        return courseRepository.findById(id).map(course -> {
            course.setName(updatedCourse.getName());
            course.setDescription(updatedCourse.getDescription());
            return courseRepository.save(course);
        });
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
