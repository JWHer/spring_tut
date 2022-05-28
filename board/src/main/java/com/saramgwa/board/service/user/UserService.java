package com.saramgwa.board.service.user;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saramgwa.board.domain.user.User;
import com.saramgwa.board.domain.user.UserRepository;
import com.saramgwa.board.web.dto.UserResponseDto;
import com.saramgwa.board.web.dto.UserSaveRequestDto;
import com.saramgwa.board.web.dto.UserUpdateRequestDto;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Transactional
    public UserResponseDto get(Long id){
        User entity = userRepository.findById(id).orElseThrow(
            ()-> new IllegalArgumentException("해당 사용자가 없습니다. id: "+id)
        );
        return new UserResponseDto(entity);
    }

    @Transactional
    public UserResponseDto save(UserSaveRequestDto requestDto){
        User entity = userRepository.save(requestDto.toEntity());
        return new UserResponseDto(entity);
    }

    @Transactional
    public UserResponseDto update(Long id, UserUpdateRequestDto requestDto){
        User entity = userRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("해당 사용자가 없습니다. id: "+id)
        );
        entity.update(requestDto.getPassword());

        return new UserResponseDto(entity);
    }

    @Transactional
    public UserResponseDto delete(Long id){
        User entity = userRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("해당 사용자가 없습니다. id: "+id)
        );
        userRepository.delete(entity);
        return new UserResponseDto(entity);
    }
}
