package com.sparta.schedule.CommentDto;

import lombok.Getter;

@Getter
public class CreateCommentResponse {

    private final String text;
    private final String writer;
    private final String password;

    public CreateCommentResponse(String text, String writer, String password) {
        this.text = text;
        this.writer = writer;
        this.password = password;
    }
}
