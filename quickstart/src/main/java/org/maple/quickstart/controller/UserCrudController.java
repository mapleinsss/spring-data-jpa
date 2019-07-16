package org.maple.quickstart.controller;

import org.maple.quickstart.dao.UserCrudRepository;
import org.maple.quickstart.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @auther Mapleins
 * @date 2019-07-16 14:33
 * @Description
 */
@Controller
@RequestMapping("userCrud")
public class UserCrudController {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @PutMapping("add")
    public void addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userCrudRepository.save(user);
    }

    @GetMapping("all")
    @ResponseBody
    public Iterable<User> getAllUser() {
        return userCrudRepository.findAll();
    }

    @GetMapping("info")
    @ResponseBody
    public User findOne(@RequestParam Long id) {
        Optional<User> optional = userCrudRepository.findById(id);
        return optional.orElse(new User());
    }

    @DeleteMapping("delete")
    public void delete(@RequestParam Long id){
        userCrudRepository.deleteById(id);
    }

}
