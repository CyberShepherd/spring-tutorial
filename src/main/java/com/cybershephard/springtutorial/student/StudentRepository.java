package com.cybershephard.springtutorial.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public Optional<Student> findStudentByEmail(String email);
    public Optional<Student> findStudentById(Long id);
    public void deleteStudentById(Long id);
    public void deleteStudentByEmail(String email);
}
