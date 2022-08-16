package com.example.school_db.Controller;

import com.example.school_db.DTO.ApiResponse;
import com.example.school_db.Model.Student;
import com.example.school_db.Model.Teacher;
import com.example.school_db.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teacher")
    public ResponseEntity getTeacher() {
        List<Teacher> teacherList = teacherService.getTeacherList();
        return ResponseEntity.status(200).body(teacherList);
    }

    @PostMapping("/teacher")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("New Teacher added!", 200));
    }


    @PutMapping("/teacher/{id}")
    public ResponseEntity updateTeacher(@RequestBody @Valid Teacher teacher, @PathVariable Integer id) {
        teacherService.updateTeacher(teacher, id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher updated!", 200));
    }

    @DeleteMapping("/teacher/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted!", 200));
    }
    @PostMapping("/teacher/find")
    public ResponseEntity findTeacher(@RequestParam Integer id){
        Teacher teacher=teacherService.findTeacher(id);
        return ResponseEntity.status(200).body(teacher);
    }
    @PostMapping("/teacher/salary")
    public ResponseEntity findTeacherSalary(@RequestParam String salary){
        List<Teacher> salaries=teacherService.findTeacherSalary(salary);
        return ResponseEntity.status(200).body(salaries);
    }

}
