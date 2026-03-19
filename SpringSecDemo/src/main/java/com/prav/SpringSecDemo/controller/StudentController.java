package com.prav.SpringSecDemo.controller;

import org.springframework.web.bind.annotation.*;

import com.prav.SpringSecDemo.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {


	List<Student> studentList=new ArrayList<>(List.of(new Student(101,"Prav",21)));

    @GetMapping
    public List<Student> getAllStudents() {
        return studentList;
    }

  
    @PostMapping
    public String addStudent(@RequestBody Student student) {
        studentList.add(student);
        return "Student added successfully!";
    }
}