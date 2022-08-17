package com.example.user_db.Controller;

import com.example.user_db.Model.Users;
import com.example.user_db.Service.UsersService;
import com.example.user_db.gto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public ResponseEntity<List> getUsers() {
        List<Users> users=usersService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/users")
    public ResponseEntity<ApiResponse> addUsers(@RequestBody @Valid Users users) {
        usersService.addUsers(users);
        return ResponseEntity.status(201).body( new ApiResponse("New users added !",201));}


    @PostMapping("/users/id")
    public ResponseEntity<Users> findUserID(@RequestParam Integer id){
        Users user=usersService.findUserID(id);
        return ResponseEntity.status(200).body(user);
    }
    @PostMapping("/users/email")
    public ResponseEntity<Users> findUserEmail(@RequestParam String email){
        Users user=usersService.findUserEmail(email);
        return ResponseEntity.status(200).body(user);
    }

    //List?
    @PostMapping("/users/age")
    public ResponseEntity<List<Users>> findUserAge(@RequestParam String age){
        List<Users> user=usersService.findUserAge(age);
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping("/users/role")
    public ResponseEntity<Integer> findRoleCount(@RequestParam String role){
        Integer user=usersService.findRoleCount(role);
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping("/users/check")
    public ResponseEntity<Boolean> CheckUser(@RequestParam String username,@RequestParam String password){
        Boolean check=usersService.CheckUser(username,password);
        return ResponseEntity.status(200).body(check);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<ApiResponse> updateStudent(@RequestBody @Valid Users user, @PathVariable Integer id) {
        usersService.updateStudent(user, id);
        return ResponseEntity.status(200).body(new ApiResponse("user updated!", 200));
    }

    @PostMapping("/users/updatePassword")
    public ResponseEntity<ApiResponse> UpdatePassword(@RequestParam Integer id,@RequestParam String password){
        usersService.UpdatePassword(id,password);
        return ResponseEntity.status(200).body(new ApiResponse("User password updated!", 200));}

    @PostMapping("/users/checkJoined")
    public ResponseEntity<ApiResponse> UserJoined(@RequestParam Integer id,@RequestParam String year){
        Boolean check=usersService.UserJoined(id,year);
        if(check){
        return ResponseEntity.status(200).body(new ApiResponse("User joined on this year", 200));
        }else{
            return ResponseEntity.status(200).body(new ApiResponse("User didn't joined on this year", 200));
        }}

    @PostMapping("/users/joined")
    public ResponseEntity<List<Users>> AllUserJoined(@RequestParam String year){
        List<Users> users=usersService.AllUserJoined(year);
            return ResponseEntity.status(200).body(users);
        }

    @PostMapping("/users/joinedAge")
    public ResponseEntity<List<Users>> AllUserJoinedAge(@RequestParam String year, @RequestParam String age){
        List<Users> users=usersService.AllUserJoinedAge(year,age);
        return ResponseEntity.status(200).body(users);
    }




}
