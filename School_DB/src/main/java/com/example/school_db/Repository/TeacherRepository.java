package com.example.school_db.Repository;

import com.example.school_db.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.beans.JavaBean;
import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    List<Teacher> findAllBySalaryIsGreaterThanEqual (String salary);
}
