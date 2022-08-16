package com.example.school_db.Service;

import com.example.school_db.Model.Teacher;
import com.example.school_db.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeacherList() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Teacher teacher, Integer id) {
        Teacher t=teacherRepository.getReferenceById(id);
        t.setName(teacher.getName());
        t.setSalary(teacher.getSalary());
        teacherRepository.save(t);
    }

    public void deleteTeacher(Integer id) {
        Teacher t=teacherRepository.getReferenceById(id);
        teacherRepository.delete(t);
    }

    public Teacher findTeacher(Integer id) {
        Teacher teacher=teacherRepository.getReferenceById(id);
        return teacher;
    }

    public List<Teacher> findTeacherSalary(String salary) {
    return teacherRepository.findAllBySalaryIsGreaterThanEqual(salary);
    }
}
