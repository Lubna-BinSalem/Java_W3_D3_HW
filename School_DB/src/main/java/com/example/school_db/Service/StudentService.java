package com.example.school_db.Service;

import com.example.school_db.Model.Student;
import com.example.school_db.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {

   private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getUsers() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student, Integer id) {
        Student oldStudent=studentRepository.getReferenceById(student.getId());
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());
        studentRepository.save(oldStudent);
    }

    public void deleteStudent(Integer id) {
        Student s=studentRepository.getReferenceById(id);
        studentRepository.delete(s);
    }

    public Student findStudent(Integer id) {
        return studentRepository.getById(id);

    }


    public Student findStudentName(String name) {
        return studentRepository.findStudentByName(name);
    }

    public List<Student> findStudentMajor(String major) {
        return studentRepository.findStudentsByMajor(major);

    }

    public List<Student> findStudentAge(String age) {
        return studentRepository.findStudentsByAgeIsGreaterThanEqual(age);
    }
}
