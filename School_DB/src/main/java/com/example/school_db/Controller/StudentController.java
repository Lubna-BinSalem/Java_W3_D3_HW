package com.example.school_db.Controller;

import com.example.school_db.DTO.ApiResponse;
import com.example.school_db.Model.Student;
import com.example.school_db.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public ResponseEntity<List> getStudent() {
        List<Student> users=studentService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/student")
    public ResponseEntity<ApiResponse> addStudent(@RequestBody @Valid Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(201).body( new ApiResponse("New student added !",201));}


    @PutMapping("/student/{id}")
    public ResponseEntity<ApiResponse> updateStudent(@RequestBody @Valid Student student, @PathVariable Integer id) {
        studentService.updateStudent(student, id);
        return ResponseEntity.status(200).body(new ApiResponse("Student updated!", 200));
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("Student deleted!", 200));
    }
    @PostMapping("/student/findID")
    public ResponseEntity<Student> findStudentID(@RequestParam Integer id){
        Student student=studentService.findStudent(id);
        return ResponseEntity.status(200).body(student);
    }

    @PostMapping("/student/find/Name")
    public ResponseEntity<Student> findStudentName(@RequestParam String name){
        Student student=studentService.findStudentName(name);
        return ResponseEntity.status(200).body(student);
    }

    @PostMapping("/student/find/major")
    public ResponseEntity<List> findStudentMajor(@RequestParam String major){
        List<Student> students=studentService.findStudentMajor(major);
        return ResponseEntity.status(200).body(students);
    }

    @PostMapping("/student/find/age")
    public ResponseEntity<List> findStudentAge(@RequestParam String age){
        List<Student> students=studentService.findStudentAge(age);
        return ResponseEntity.status(200).body(students);
    }

}
