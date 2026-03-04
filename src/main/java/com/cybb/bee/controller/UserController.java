package com.cybb.bee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cybb.bee.mapper.UserMapper;
import com.cybb.bee.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public List<User> list() {
        return userMapper.findAll();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return userMapper.findById(id);
    }

    @PostMapping
    public int create(@RequestBody User user) {
        return userMapper.insert(user);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userMapper.update(user);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        return userMapper.delete(id);
    }
}
