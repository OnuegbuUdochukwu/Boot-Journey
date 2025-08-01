package com.codewithudo.studentmanagementsystem.service;

import com.codewithudo.studentmanagementsystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    private final ArrayList<Student> students = new ArrayList<>();
    private int nextId = 1;

    public ArrayList<Student> addStudent(Student student) {
        student.setId(nextId++);;
        students.add(student);
        return students;
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == (id)) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public boolean updateStudent(int id, Student student) {
        for (Student student1 : students) {
            if (student1.getId() == (id)) {
                student1.setName(student.getName());
                student1.setAge(student.getAge());
                student1.setCourse(student.getCourse());
                student1.setEmail(student.getEmail());
                return true;
            }
        }
        return false;
    }

    public boolean removeStudent(int id) {
        return students.removeIf(student -> student.getId() == (id));
    }

}
