package com.saramgwa.board.web.dto.Post;

import java.time.LocalDateTime;

import com.saramgwa.board.domain.post.Post;
import com.saramgwa.board.web.dto.User.UserResponseDto;

import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private UserResponseDto author;
    private Integer views;
    private LocalDateTime created;
    private LocalDateTime updated;

    public PostResponseDto(Post entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.content=entity.getContent();
        this.author=new UserResponseDto(entity.getAuthor());
        this.views=entity.getViews();
        this.created=entity.getCreated();
        this.updated=entity.getUpdated();
    }
}
