package com.cybershephard.springtutorial.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(new Student(1L, "Gabon", "gabriel.m@op.pl", LocalDate.of(2000, 12, 3), 21));
    }
}
