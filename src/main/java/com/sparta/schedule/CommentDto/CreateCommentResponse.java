package com.sparta.schedule.CommentDto;

import lombok.Getter;

@Getter
public class CreateCommentResponse {

    private final Long id;
    private final String text;
    private final String writer;
    private final String password;

    public CreateCommentResponse(Long id, String text, String writer, String password) {
        this.id = id;
        this.text = text;
        this.writer = writer;
        this.password = password;
    }
}
