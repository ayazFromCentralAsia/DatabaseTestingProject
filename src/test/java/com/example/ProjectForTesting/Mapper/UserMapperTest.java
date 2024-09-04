package com.example.ProjectForTesting.Mapper;

import com.example.ProjectForTesting.Dto.UserDto;
import com.example.ProjectForTesting.Entity.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    @Test
    void userDtoMapper() {
        User user = new User(1,"TestPass","Test","123321","Test", LocalDate.now());
        UserMapper userMapper = new UserMapper();

        UserDto userDto = userMapper.userDtoMapper(user);

        assertAll("TestForAll",
                () -> assertEquals("TestPass",userDto.getUsername()),
                () -> assertEquals("Test",userDto.getEmail()),
                () -> assertEquals("123321",userDto.getPassword()));
    }

    @Test
    void userMapper() {
        UserDto userDto = new UserDto("TestPass","Test","123321","Test");
        UserMapper userMapper = new UserMapper();

        User user = userMapper.userMapper(userDto);

        assertAll("TestForAll",
                () -> assertEquals("TestPass",userDto.getUsername()),
                () -> assertEquals("Test",userDto.getEmail()),
                () -> assertEquals("123321",userDto.getPassword()));
    }
}