package com.example.user_db.Repository;

import com.example.user_db.Model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
    Users findAllById(Integer ID);

    List<Users> findUsersByAgeGreaterThan(String age);
    Users findUsersByEmail(String email);

    Integer countAllByRole(String role);

    @Query("select u from Users u where u.username=?1 and u.password=?2")
    Users findByUsernameAndPassword(String username, String password);

    List<Users> findAllByJoiningYearIsGreaterThanEqual(String year);

    List<Users> findAllByJoiningYearLessThanEqualAndAgeEquals (String year,String age);

//    @Query("select COUNT(*) from Users")
//    Integer countAllBy

}
