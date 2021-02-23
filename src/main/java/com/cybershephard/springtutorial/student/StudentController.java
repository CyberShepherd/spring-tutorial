package com.cybershephard.springtutorial.student;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student){
        this.studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "/{id}")
    public void removeStudentByEmail(@PathVariable Long id){
        studentService.removeStudent(id);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }
}
