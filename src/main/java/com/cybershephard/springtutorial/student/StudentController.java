package com.cybershephard.springtutorial.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(path = "/{id}")
    public ResponseEntity updateStudent(@PathVariable Long id,
                                        @RequestParam(required = false) String name,
                                        @RequestParam(required = false) String email){
        return studentService.updateStudent(id, name, email);
    }
}
