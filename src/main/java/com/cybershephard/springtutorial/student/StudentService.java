package com.cybershephard.springtutorial.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        if(isStudent(student.getEmail())) throw new IllegalStateException("Email taken");
        studentRepository.save(student);
    }

    public void updateStudent(Student student){
        if(!isStudent(student.getId())) throw new IllegalStateException("Student doesn't exist");
        studentRepository.save(student);
    }

    public void removeStudent(String email){
        if(!isStudent(email)) throw new IllegalStateException("Student doesn't exist");
        studentRepository.deleteStudentByEmail(email);
    }

    public void removeStudent(Long id){
        if(!isStudent(id)) throw new IllegalStateException("Student doesn't exist");
        studentRepository.deleteStudentById(id);
    }

    /**
     * If student of corresponding id exists, returns true
     * @param id
     * @return
     */
    public boolean isStudent(Long id){
        Optional<Student> optionalStudent = studentRepository.findStudentById(id);
        if(optionalStudent.isPresent()) return true;
        else return false;
    }

    /**
     * if student of corresponding email exists, returns true
     * @param email
     * @return
     */
    public boolean isStudent(String email){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
        if(studentOptional.isPresent()) return true;
        else return false;
    }
}
