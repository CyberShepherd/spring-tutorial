package com.cybershephard.springtutorial.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    TODO: remove insert
    public List<Student> getStudents(){
        Student student = new Student(1L,"gabriel", "gabriel.m@op.pl", LocalDate.of(2000,10,1), 21);
        studentRepository.save(student);
        return studentRepository.findAll();
    }
}
