package com.codewithudo.studentmanagementsystem.controller;

import com.codewithudo.studentmanagementsystem.model.Student;
import com.codewithudo.studentmanagementsystem.service.StudentService;
import com.sun.jdi.event.StepEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<ArrayList<Student>> addStudent(@RequestBody Student student) {
        ArrayList<Student> updatedStudent = studentService.addStudent(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody Student student) {
        boolean updated = studentService.updateStudent(id, student);
        if (updated) {
            return new ResponseEntity<>("Student updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        boolean deleted = studentService.removeStudent(id);
        if (deleted) {
            return new ResponseEntity<>("Student deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }
}
