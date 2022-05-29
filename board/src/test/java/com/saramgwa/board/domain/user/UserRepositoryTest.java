package com.saramgwa.board.domain.user;

import java.util.List;

// import com.saramgwa.board.web.UserController;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @After
    public void deleteAll(){
        userRepository.deleteAll();
    }

    @Test
    public void testUserList(){
        String username = "test_username";
        String password = "test_password";
        // User cuser = User.builder().username(username).password(password).role(Role.USER.name()).build();
        userRepository.save(User.builder().username(username).password(password).role(Role.USER).build());

        List<User> userList = userRepository.findAll();

        User user = userList.get(0);
        assertThat(user.getUsername()).isEqualTo(username);
        assertThat(user.getPassword()).isEqualTo(password);
    }
}
