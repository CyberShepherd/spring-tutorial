package com.cybershephard.springtutorial.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.cybershephard.springtutorial.student.StudentLogic.validateEmail;
import static com.cybershephard.springtutorial.student.StudentLogic.validateName;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResponseEntity getStudents(){
        return new ResponseEntity<List<Student>>(studentRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity addNewStudent(Student student){
        if(isStudent(student.getEmail()))
            return new ResponseEntity<String>("Email is taken", HttpStatus.INTERNAL_SERVER_ERROR);
        studentRepository.save(student);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity updateStudent(Long id, String name, String email){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(!optionalStudent.isPresent())
            return new ResponseEntity<String>("Student doesn't exist", HttpStatus.INTERNAL_SERVER_ERROR);
        Student student = optionalStudent.get();
        if(validateName(student.getName(), name)) student.setName(name);
        if(validateEmail(student.getEmail(), email)) student.setEmail(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity removeStudent(String email){
        if(!isStudent(email))
            return new ResponseEntity<String>("Student doesn't exist", HttpStatus.INTERNAL_SERVER_ERROR);
        studentRepository.deleteStudentByEmail(email);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity removeStudent(Long id){
        if(!studentRepository.existsById(id)) return new ResponseEntity<String>("Student doesn't exist", HttpStatus.INTERNAL_SERVER_ERROR);
        studentRepository.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    /**
     * If student of corresponding id exists, returns true
     * @param id
     * @return
     */
    private boolean isStudent(Long id){
        Optional<Student> optionalStudent = studentRepository.findStudentById(id);
        if(optionalStudent.isPresent()) return true;
        else return false;
    }

    /**
     * if student of corresponding email exists, returns true
     * @param email
     * @return
     */
    private boolean isStudent(String email){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
        if(studentOptional.isPresent()) return true;
        else return false;
    }


}
