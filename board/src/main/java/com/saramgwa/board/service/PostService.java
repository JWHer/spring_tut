package com.saramgwa.board.service;

import java.util.List;

import javax.transaction.Transactional;

import com.saramgwa.board.config.auth.SessionUser;
import com.saramgwa.board.domain.post.Post;
import com.saramgwa.board.domain.post.PostRepository;
import com.saramgwa.board.domain.user.User;
import com.saramgwa.board.domain.user.UserRepository;
import com.saramgwa.board.web.dto.Post.PostCreateRequestDto;
import com.saramgwa.board.web.dto.Post.PostResponseDto;
import com.saramgwa.board.web.dto.Post.PostUpdateRequestDto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {
    private static final String ILLEGAL_ARG_EXCP = "There is no such post id: ";
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<Post> readAll(){
        return postRepository.findAll();
    }

    @Transactional
    public PostResponseDto read(Long id){
        Post entity = postRepository.findById(id).orElseThrow(
            ()-> new IllegalArgumentException(ILLEGAL_ARG_EXCP+id)
        );
        return new PostResponseDto(entity);
    }

    @Transactional
    public PostResponseDto create(
        PostCreateRequestDto cerateDto,
        SessionUser sessionUser
    ){
        User author = userRepository.findById(sessionUser.getId()).orElseThrow(
            () -> new IllegalArgumentException("Session user not exist id: "+sessionUser.getId())
        );
        Post entity = postRepository.save(cerateDto.toEntity(author));
        return new PostResponseDto(entity);
    }

    @Transactional
    public PostResponseDto update(Long id, PostUpdateRequestDto updateDto){
        Post entity = postRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException(ILLEGAL_ARG_EXCP+id)
        );
        entity.update(updateDto.getTitle(), updateDto.getContent());

        return new PostResponseDto(entity);
    }

    @Transactional
    public PostResponseDto delete(Long id){
        Post entity = postRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException(ILLEGAL_ARG_EXCP+id)
        );
        postRepository.delete(entity);
        return new PostResponseDto(entity);
    }
}
