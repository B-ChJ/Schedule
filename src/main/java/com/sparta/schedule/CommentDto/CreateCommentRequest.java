package com.sparta.schedule.CommentDto;

import lombok.Getter;

@Getter
public class CreateCommentRequest {

    private String text;
    private String writer;
    private String password;

}
