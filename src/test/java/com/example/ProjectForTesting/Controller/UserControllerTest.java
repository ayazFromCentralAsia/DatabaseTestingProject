package com.example.ProjectForTesting.Controller;

import com.example.ProjectForTesting.Dto.UserDto;
import com.example.ProjectForTesting.Entity.User;
import com.example.ProjectForTesting.Mapper.UserMapper;
import com.example.ProjectForTesting.Service.UserService;
import com.google.gson.Gson;
import org.aspectj.weaver.ast.Var;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.net.http.HttpClient;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserMapper userMapper;

    @Test
    void userList(){
        var list = List.of(
                new User(1, "TestPass", "Test", "123321", "Test", LocalDate.now()),
                new User(2, "TestPass2", "Test2", "1233212", "Test2", LocalDate.now())
        );
        when(userService.getAllUsers()).thenReturn(list);

        try {
            mockMvc.perform(get("/user"))
                    .andExpect(jsonPath("$[0].username").value("TestPass"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void createUser() {
        UserDto userDto  =new UserDto("TestName","TestNamePlust@example.com","password","Test");
        User user = new User(1,"TEST","TESTING@example.com","password","TEST",LocalDate.now());
        when(userMapper.userMapper(any(UserDto.class))).thenReturn(user);

        doNothing().when(userService).createUser(any(User.class));

        Gson gson = new Gson();

        String jsonUserDto = gson.toJson(userDto);

        try {
            mockMvc.perform(post("/user/create")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonUserDto))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Good Request"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        verify(userService, times(1)).createUser(any(User.class));
    }

    @Test
    void findById() {
        // I'll do it all in a while
    }

    @Test
    void editUser() {
    }

    @Test
    void deleteUser() {
    }
}