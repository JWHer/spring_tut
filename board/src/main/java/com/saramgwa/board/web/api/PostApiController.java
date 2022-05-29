package com.saramgwa.board.web.api;

import java.util.List;

import com.saramgwa.board.config.auth.LoginUser;
import com.saramgwa.board.config.auth.SessionUser;
import com.saramgwa.board.domain.post.Post;
import com.saramgwa.board.service.PostService;
import com.saramgwa.board.web.dto.Post.PostCreateRequestDto;
import com.saramgwa.board.web.dto.Post.PostResponseDto;
import com.saramgwa.board.web.dto.Post.PostUpdateRequestDto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PostApiController {
    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> readAll() {
        return postService.readAll(); 
    }

    @GetMapping("/posts/{id}")
    public PostResponseDto read(@PathVariable Long id) {
        return postService.read(id);
    }

    @PostMapping("/posts")
    public PostResponseDto create(
        @RequestBody PostCreateRequestDto createDto,
        @ApiIgnore @LoginUser SessionUser sessionUser
    ){
        return postService.create(createDto, sessionUser);
    }

    @PutMapping("/posts/{id}")
    public PostResponseDto update(@PathVariable Long id, @RequestBody PostUpdateRequestDto updateDto){
        return postService.update(id, updateDto);
    }

    @DeleteMapping("/posts/{id}")
    public PostResponseDto delete(@PathVariable Long id){
        return postService.delete(id);
    }
}
