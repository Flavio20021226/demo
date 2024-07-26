package com.example.demo_Eturia.services;

import com.example.demo_Eturia.entities.Course;
import com.example.demo_Eturia.entities.Student;
import com.example.demo_Eturia.repo.CourseRepository;
import com.example.demo_Eturia.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student addCourseToStudent(Long studentId, Long courseId) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<Course> courseOpt = courseRepository.findById(courseId);

        if (studentOpt.isPresent() && courseOpt.isPresent()) {
            Student student = studentOpt.get();
            Course course = courseOpt.get();
            student.getCourses().add(course);
            Student updatedStudent = studentRepository.save(student);

            updatedStudent.getCourses().size();
            return updatedStudent;
        }

        return null;
    }

    public Student removeCourseFromStudent(Long studentId, Long courseId) {
        Optional<Student> studentOpt = studentRepository.findById(studentId); 
        Optional<Course> courseOpt = courseRepository.findById(courseId);
    
        if (studentOpt.isPresent() && courseOpt.isPresent()) {
            Student student = studentOpt.get();
            Course course = courseOpt.get();
            student.getCourses().remove(course);
            return studentRepository.save(student);
        }
    
        return null;
    }
}
