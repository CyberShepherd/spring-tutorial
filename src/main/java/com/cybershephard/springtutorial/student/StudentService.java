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
        Student student1 = new Student("gabriel", "gabriel.m@op.pl", LocalDate.of(2000,10,1), 21);
        Student student2 = new Student("flair", "flair.mail@op.pl", LocalDate.of(1996,4,12), 25);
        List<Student> students = List.of(student1, student2);
        studentRepository.saveAll(students);
        return studentRepository.findAll();
    }
}
