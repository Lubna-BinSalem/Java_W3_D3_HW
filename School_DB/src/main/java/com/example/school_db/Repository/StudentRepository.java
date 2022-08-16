package com.example.school_db.Repository;

import com.example.school_db.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findStudentById(Integer id);

    Student findStudentByName(String name);

    List<Student> findStudentsByMajor(String major);

    List<Student> findStudentsByAgeIsGreaterThanEqual (String age);

}
