package com.sparta.schedule.CommentDto;

import lombok.Getter;

@Getter
public class CreateCommentResponse {

    private final String text;
    private final String writer;
    private final String password;
    private final Long scheduleId;

    public CreateCommentResponse(String text, String writer, String password, Long scheduleId) {
        this.text = text;
        this.writer = writer;
        this.password = password;
        this.scheduleId = scheduleId;
    }
}
