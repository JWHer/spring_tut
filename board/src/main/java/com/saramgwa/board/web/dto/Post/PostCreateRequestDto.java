package com.saramgwa.board.web.dto.Post;

import com.saramgwa.board.domain.post.Post;
import com.saramgwa.board.domain.user.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCreateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostCreateRequestDto(String title, String content){
        this.title=title;
        this.content=content;
    }

    public Post toEntity(User author){
        return Post.builder().title(title).content(content).author(author).build();
    }
}
