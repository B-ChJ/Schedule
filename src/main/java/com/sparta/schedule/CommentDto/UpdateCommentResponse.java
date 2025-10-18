package com.sparta.schedule.CommentDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateCommentResponse {
    private final Long id;
    private final String text;
    private final String writer;
    private final LocalDateTime modifiedAt;

    public UpdateCommentResponse(Long id, String text, String writer, LocalDateTime modifiedAt) {
        this.id = id;
        this.text = text;
        this.writer = writer;
        this.modifiedAt = modifiedAt;
    }
}
