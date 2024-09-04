package com.example.ProjectForTesting.Mapper;

import com.example.ProjectForTesting.Dto.UserDto;
import com.example.ProjectForTesting.Entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class UserMapper {
    public UserDto userDtoMapper(User user){
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        return userDto;
    }

    public User userMapper(UserDto userDto){
        User user = new User();
        user.setId(user.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        user.setEmail(userDto.getEmail());
        user.setCreated_at(LocalDate.now());
        return user;
    }
}
