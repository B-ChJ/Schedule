package com.sparta.schedule.controller;

import com.sparta.schedule.CommentDto.*;
import com.sparta.schedule.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/schedules/{scheduleId}")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comments")
    public ResponseEntity<CreateCommentResponse> create(@PathVariable Long scheduleId, CreateCommentRequest request) {
        CreateCommentResponse result = commentService.create(scheduleId, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
