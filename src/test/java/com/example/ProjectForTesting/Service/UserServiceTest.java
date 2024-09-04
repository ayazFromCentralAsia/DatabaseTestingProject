package com.example.ProjectForTesting.Service;

import com.example.ProjectForTesting.Entity.User;
import com.example.ProjectForTesting.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import javax.xml.transform.Result;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        User user = new User(1, "John", "Test", "test", "USER", LocalDate.now());

        userService.createUser(user);

        verify(userRepository, times(1)).save(user);
    }

    @Test
    void getUserById() {
        User user = new User(1,"TestPassed","Test","Test","Test",LocalDate.now());
        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.getUserById(1);

        assertEquals(true, foundUser.isPresent());
        assertEquals("TestPassed", foundUser.get().getUsername());
    }

    @Test
    void getUserByUsername() {
        when(userRepository.findByUsername("John")).thenReturn(new User(1,"John","Test","Test","Test", LocalDate.now()));

        User user = userService.getUserByUsername("John");

        assertEquals("John",user.getUsername());
    }

    @Test
    void getAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1,"John","Test","Test","Test", LocalDate.now()));
        userList.add(new User(2,"Led","Test","Test","Test", LocalDate.now()));
        when(userRepository.findAll()).thenReturn(userList);

        List<User> list = userService.getAllUsers();

        assertEquals(list,userList);
    }

    @Test
    void updateUser() {
        User userFirst = new User(0, "John", "Test", "Test", "Test", LocalDate.now());
        User user = new User(0, "NotJohn", "Test", "Test", "Test", LocalDate.now());
        when(userRepository.findById(0)).thenReturn(Optional.of(userFirst));
        when(userRepository.save(userFirst)).thenReturn(userFirst);

        User userEdited = userService.updateUser(0,user);

        assertEquals("NotJohn",userEdited.getUsername());
        assertEquals("Test",userEdited.getPassword());
    }

    @Test
    void deleteUser() {
        int userId = 1;

        userService.deleteUser(userId);

        verify(userRepository,times(1)).deleteById(userId);
    }
}