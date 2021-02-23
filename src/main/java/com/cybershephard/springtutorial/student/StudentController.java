package com.cybershephard.springtutorial.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public ResponseEntity addNewStudent(@RequestBody Student student){
        return this.studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity removeStudentByEmail(@PathVariable Long id){
        return studentService.removeStudent(id);
    }

    @PutMapping
    public ResponseEntity updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }
}
