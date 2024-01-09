package com.mehdi.socialmedia.controller;

import com.mehdi.socialmedia.models.User;
import com.mehdi.socialmedia.repository.UserRepository;
import com.mehdi.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;




    @GetMapping("/api/users")
    public List<User> getUsers(){
        List<User> users = userRepository.findAll();

        return users;

    }


    @GetMapping("/api/users/{userId}")
    public User getUsersById(@PathVariable("userId") Integer id) throws Exception {
        User user = userService.findUserById(id);
        return user;
    }


    @PutMapping("/api/users/{userId}")
    public User updateUser(@RequestBody User user,@PathVariable Integer userId) throws Exception {

        User updatedUser = userService.updateUser(user,userId);
        return updatedUser;
    }

    @PutMapping("/api/users/follow/{userId1}/{userId2}")
    public User followUserHandler(@PathVariable Integer userId1,@PathVariable Integer userId2) throws Exception {

        User user = userService.followUser(userId1,userId2);
        return user;
    }

    @GetMapping("/api/users/search")
    public List<User> searchUser(@RequestParam("query") String query){
        List<User> users = userService.searchUser(query);

        return users;
    }


//    @DeleteMapping("users/{userId}")
//    public String deleteUser(@PathVariable("userId") Integer userId) throws Exception {
//        Optional <User> user = userRepository.findById(userId);
//
//        if (user.isEmpty()){
//            throw new Exception("user not exit with id " + userId);
//        }
//        userRepository.delete(user.get());
//
//        return "user deleted successfully with id " + userId;
//    }




}
