package com.sparta.schedule.controller;

import com.sparta.schedule.CommentDto.*;
import com.sparta.schedule.ScheduleDto.CreateScheduleResponse;
import com.sparta.schedule.ScheduleDto.UpdateScheduleResponse;
import com.sparta.schedule.repository.CommentRepository;
import com.sparta.schedule.service.CommentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CreateCommentResponse> create(@PathVariable("scheduleId") Long scheduleId, CreateCommentRequest request) {
        CreateCommentResponse result = commentService.create(scheduleId, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<List<GetCommentResponse>> getAllComments(@PathVariable Long scheduleId) {
        List<GetCommentResponse> result = commentService.getById(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/schedules/{scheduleId}/comments/{commentId}")
    public ResponseEntity<UpdateCommentResponse> update(@PathVariable Long scheduleId, @PathVariable Long commentId,
                                                         @RequestBody UpdateCommentRequest request) {
        UpdateCommentResponse result = commentService.update(commentId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/schedules/{scheduleId}/comments/{commentId}")
    public ResponseEntity<Void> delete(@PathVariable Long scheduleId, @PathVariable Long commentId, @RequestBody DeleteCommentRequest request) {
        commentService.delete(commentId, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
