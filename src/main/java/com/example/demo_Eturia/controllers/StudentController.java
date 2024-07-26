package com.example.demo_Eturia.controllers;

import com.example.demo_Eturia.entities.Student;
import com.example.demo_Eturia.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<Student> addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        Student student = studentService.addCourseToStudent(studentId, courseId);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<Void> removeCourseFromStudent(@PathVariable Long studentId, @PathVariable Long courseId) {        
        Student student = studentService.removeCourseFromStudent(studentId, courseId);
        return student != null ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
