package com.example.ProjectForTesting.Controller;


import com.example.ProjectForTesting.Dto.UserDto;
import com.example.ProjectForTesting.Entity.User;
import com.example.ProjectForTesting.Mapper.UserMapper;
import com.example.ProjectForTesting.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    public UserController(UserMapper userMapper,UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping
    public List<User> userList(){
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto ){
        System.out.println(userMapper.userMapper(userDto).toString());
        User user = userMapper.userMapper(userDto);
        userService.createUser(user);
        return ResponseEntity.ok().body("Good Request");
    }

    @GetMapping("/byId")
    public ResponseEntity<?> findById(@RequestParam int id){
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка при создании User");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editUser(@RequestBody UserDto userDto,@RequestParam int id){
        try {
            return ResponseEntity.ok(userService.updateUser(id,userMapper.userMapper(userDto)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка при Изменений обьекта");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id){
        if (userService.getUserById(id).isPresent()){
            userService.deleteUser(id);
            ResponseEntity.status(HttpStatus.OK);
        }else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Неправильно веденные данные");
        }
    }
}
