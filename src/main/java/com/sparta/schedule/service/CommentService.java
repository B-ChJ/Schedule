package com.sparta.schedule.service;

import com.sparta.schedule.CommentDto.*;
import com.sparta.schedule.entity.Comment;
import com.sparta.schedule.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    //CREATE
    @Transactional
    public CreateCommentResponse create(CreateCommentRequest request) {
        Comment comment = new Comment(request.getText(),
                request.getWriter(),
                request.getPassword());

        Comment savedComment = commentRepository.save(comment);

        return new CreateCommentResponse(savedComment.getText(),
                savedComment.getWriter(),
                savedComment.getPassword());
    }
    //READ
    @Transactional(readOnly = true)
    public GetCommentResponse getById(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 댓글입니다."));

        return new GetCommentResponse(comment.getId(),
                comment.getText(),
                comment.getWriter(),
                comment.getCreatedAt(),
                comment.getModifiedAt());
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
        if(!(comment.getPassword().equals(request.getPassword()))) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        commentRepository.deleteById(commentId);
    }
}
