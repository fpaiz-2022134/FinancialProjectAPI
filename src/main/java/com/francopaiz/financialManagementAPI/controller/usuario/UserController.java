package com.francopaiz.financialManagementAPI.controller.usuario;

import com.francopaiz.financialManagementAPI.model.User;
import com.francopaiz.financialManagementAPI.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{idUser}")
    public User findById(@PathVariable String idUser){
        return userService.findById(idUser);
    }

    @PostMapping()
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/{idUser}")
    public User update(@PathVariable String idUser, @RequestBody User user){
        return userService.update(idUser, user);
    }

    @DeleteMapping("/{idUser}")
    public void deleteById(@PathVariable String idUser){
        userService.deleteById(idUser);
    }
}
