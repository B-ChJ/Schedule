package com.sparta.schedule.CommentDto;

import lombok.Getter;

@Getter
public class UpdateCommentRequest {
    private String text;
    private String writer;
    private String passwordComment;
}
