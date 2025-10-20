package com.sparta.schedule.CommentDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetCommentResponse {
    private Long id;
    private String text;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public GetCommentResponse(Long id, String text, String writer,
                              LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.text = text;
        this.writer = writer;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
