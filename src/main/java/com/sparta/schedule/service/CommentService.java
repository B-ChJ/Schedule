package com.sparta.schedule.service;

import com.sparta.schedule.CommentDto.*;
import com.sparta.schedule.entity.Comment;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.CommentRepository;
import com.sparta.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    //CREATE
    @Transactional
    public CreateCommentResponse create(Long scheduleId, CreateCommentRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다."));
        Long countComment = commentRepository.countCommentsBySchedule(schedule);

        if(countComment >= 10) {
            throw new IllegalStateException("한 일정에 등록할 수 있는 댓글은 10개까지 가능합니다.");
        }

        Comment comment = new Comment(request.getText(),
                request.getWriter(),
                request.getPassword(),
                schedule);

        schedule.addComment(comment);
        Comment savedComment = commentRepository.save(comment);

        return new CreateCommentResponse(savedComment.getId(),
                savedComment.getText(),
                savedComment.getWriter(),
                savedComment.getPassword());
    }

    //READ
    @Transactional(readOnly = true)
    public List<GetCommentResponse> getById(Long scheduleId) {
        List<Comment> commentAll = commentRepository.findAll();
        List<GetCommentResponse> commentById = new ArrayList<>();

        for (Comment comment : commentAll) {

                GetCommentResponse dto = new GetCommentResponse(comment.getId(),
                        comment.getText(),
                        comment.getWriter(),
                        comment.getCreatedAt(),
                        comment.getModifiedAt());

                commentById.add(dto);
            }
        return commentById;

//        for (Comment comment : commentAll) {
//            if (comment.getSchedule.getId().equals(scheduleId)) {
//                GetCommentResponse dto = new GetCommentResponse(comment.getId(),
//                        comment.getText(),
//                        comment.getWriter(),
//                        comment.getCreatedAt(),
//                        comment.getModifiedAt());
//
//                commentById.add(dto);
//            }
//        }
//
//        return commentById;
    }

    //UPDATE
    @Transactional
    public UpdateCommentResponse update(Long commentId, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 댓글입니다."));
        if (!(comment.getPassword().equals(request.getPasswordComment()))) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        comment.update(request.getText(), request.getWriter());

        return new UpdateCommentResponse(comment.getId(),
                comment.getText(),
                comment.getWriter(),
                comment.getModifiedAt());
    }

    //DELETE
    @Transactional
    public void delete(Long commentId, DeleteCommentRequest request) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 댓글입니다."));
        if (!(comment.getPassword().equals(request.getPasswordComment()))) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        commentRepository.deleteById(commentId);
    }
}
