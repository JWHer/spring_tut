package com.saramgwa.board.web.api;


import com.saramgwa.board.domain.user.Role;
import com.saramgwa.board.domain.user.User;
import com.saramgwa.board.domain.user.UserRepository;
import com.saramgwa.board.web.dto.User.UserCreateRequestDto;
import com.saramgwa.board.web.dto.User.UserUpdateRequestDto;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @After
    public void tearDown() throws Exception {
        userRepository.deleteAll();
    }

    @Test
    public void createUser() throws Exception {
        String username = "test_username";
        String password = "test_password";
        UserCreateRequestDto requestDto = UserCreateRequestDto.builder()
            .username(username).password(password).build();
        String url = "http://localhost:"+port+"/api/v1/users";

        ResponseEntity<User> responseEntity
            = restTemplate.postForEntity(url, requestDto, User.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        // assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<User> all = userRepository.findAll();
        assertThat(all.get(0).getUsername()).isEqualTo(username);
        assertThat(all.get(0).getPassword()).isEqualTo(password);
    }

    @Test
    public void updateUser() throws Exception {
        User savedUser = userRepository.save(
            User.builder().username("org_name").password("org_pw").role(Role.USER).build()
        );

        Long updateId = savedUser.getId();
        String password = "new_password";
        UserUpdateRequestDto requestDto = UserUpdateRequestDto.builder().password(password).role(Role.ADMIN).build();
        String url = "http://localhost:"+port+"/api/v1/users/"+updateId;
        HttpEntity<UserUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        ResponseEntity<User> responseEntity = restTemplate.exchange(
            url, HttpMethod.PUT,
            requestEntity, User.class   
        );
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        System.out.println(responseEntity.getBody());

        User user = userRepository.findById(updateId).orElseThrow();
        assertThat(user.getPassword()).isEqualTo(password);
    }
}
