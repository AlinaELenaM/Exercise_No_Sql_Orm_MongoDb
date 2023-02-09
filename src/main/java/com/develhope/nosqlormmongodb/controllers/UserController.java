package com.develhope.nosqlormmongodb.controllers;

import com.develhope.nosqlormmongodb.entities.User;
import com.develhope.nosqlormmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping("")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new Exception("User is not found!");
        }
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody  User user) throws Exception{
        if(!userRepository.existsById(id)) throw new Exception("User is not found");
        user.setId(id);
        return userRepository.save(user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
    }

}
