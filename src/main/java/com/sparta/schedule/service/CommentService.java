package com.sparta.schedule.service;

import com.sparta.schedule.CommentDto.*;
import com.sparta.schedule.entity.Comment;
import com.sparta.schedule.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    //CREATE
    @Transactional
    public CreateCommentResponse create(CreateCommentRequest request) {
        Comment comment = new Comment(request.getText(),
                request.getWriter(),
                request.getPassword(),
                request.getScheduleId());

        Comment savedComment = commentRepository.save(comment);

        return new CreateCommentResponse(savedComment.getText(),
                savedComment.getWriter(),
                savedComment.getPassword(),
                savedComment.getScheduleId());
    }

    //READ
    @Transactional(readOnly = true)
    public List<GetCommentResponse> getById(Long scheduleId) {
        List<Comment> commentAll = commentRepository.findAll();
        List<GetCommentResponse> commentById = new ArrayList<>();

        for (Comment comment : commentAll) {
            if (comment.getScheduleId().equals(scheduleId)) {
                GetCommentResponse dto = new GetCommentResponse(comment.getId(),
                        comment.getText(),
                        comment.getWriter(),
                        comment.getScheduleId(),
                        comment.getCreatedAt(),
                        comment.getModifiedAt());

                commentById.add(dto);
            }
        }

        return commentById;
    }

    //UPDATE
    @Transactional
    public UpdateCommentResponse update(Long commentId, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 댓글입니다."));
        if (!(comment.getPassword().equals(request.getPassword()))) {
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
        if (!(comment.getPassword().equals(request.getPassword()))) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        commentRepository.deleteById(commentId);
    }
}
