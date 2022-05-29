package com.saramgwa.board.service;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saramgwa.board.domain.user.User;
import com.saramgwa.board.domain.user.UserRepository;
import com.saramgwa.board.web.dto.User.UserCreateRequestDto;
import com.saramgwa.board.web.dto.User.UserResponseDto;
import com.saramgwa.board.web.dto.User.UserUpdateRequestDto;

@RequiredArgsConstructor
@Service
public class UserService {
    private static final String ILLEGAL_ARG_EXCP = "There is no such user id: ";
    private final UserRepository userRepository;

    @Transactional
    public List<User> readAll(){
        return userRepository.findAll();
    }

    @Transactional
    public UserResponseDto read(Long id){
        User entity = userRepository.findById(id).orElseThrow(
            ()-> new IllegalArgumentException(ILLEGAL_ARG_EXCP+id)
        );
        return new UserResponseDto(entity);
    }

    @Transactional
    public UserResponseDto create(UserCreateRequestDto requestDto){
        User entity = userRepository.save(requestDto.toEntity());
        return new UserResponseDto(entity);
    }

    @Transactional
    public UserResponseDto update(Long id, UserUpdateRequestDto requestDto){
        User entity = userRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException(ILLEGAL_ARG_EXCP+id)
        );
        entity.update(requestDto.getPassword(), requestDto.getRole());

        return new UserResponseDto(entity);
    }

    @Transactional
    public UserResponseDto delete(Long id){
        User entity = userRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException(ILLEGAL_ARG_EXCP+id)
        );
        userRepository.delete(entity);
        return new UserResponseDto(entity);
    }
}
