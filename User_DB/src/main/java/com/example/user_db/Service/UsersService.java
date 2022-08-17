package com.example.user_db.Service;


import com.example.user_db.Model.Users;
import com.example.user_db.Repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    public void addUsers(Users users) {
        usersRepository.save(users);
    }
    

    public Users findUserID(Integer id) {
        return usersRepository.findAllById(id);
    }


    public List<Users> findUserAge(String age) {
        return usersRepository.findUsersByAgeGreaterThan(age);

    }
    public Users findUserEmail(String email) {
        return usersRepository.findUsersByEmail(email);
    }


    public Integer findRoleCount(String role) {
        return usersRepository.countAllByRole(role);
    }

    public Boolean CheckUser(String username, String password) {
        Users user=usersRepository.findByUsernameAndPassword(username,password);
        if(user==null){
            return false;
        }else{
            return true;
        }
    }

    public void updateStudent(Users user, Integer id) {
        Users admin=usersRepository.getReferenceById(id);
        if(admin.getRole().equals("admin")){
        Users oldUser=usersRepository.getById(user.getId());
            oldUser.setUsername(user.getUsername());
            oldUser.setPassword(user.getPassword());
            oldUser.setEmail(user.getEmail());
            oldUser.setRole(user.getRole());
            oldUser.setJoiningYear(user.getJoiningYear());
            oldUser.setAge(user.getAge());
        usersRepository.save(oldUser);}
    }

    public void UpdatePassword(Integer id, String password) {
        Users oldUser=usersRepository.getById(id);
        oldUser.setPassword(password);
        usersRepository.save(oldUser);
    }

    public Boolean UserJoined(Integer id, String year) {
    Users user = usersRepository.getById(id);
    if(user.getJoiningYear().equals(year)){
        return true;
    }else{
        return false;}
    }

    public List<Users> AllUserJoined(String year) {
    return usersRepository.findAllByJoiningYearIsGreaterThanEqual(year);
    }

    public List<Users> AllUserJoinedAge(String year, String age) {
    return usersRepository.findAllByJoiningYearLessThanEqualAndAgeEquals(year,age);    }
}
