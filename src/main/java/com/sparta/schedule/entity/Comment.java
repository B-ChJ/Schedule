package com.sparta.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String text;
    @Column(nullable = false)
    private String writer;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Long scheduleId;

    public Comment(String text, String writer, String password, Long scheduleId) {
        this.text = text;
        this.writer = writer;
        this.password = password;
        this.scheduleId = scheduleId;
    }
    public void update(String text, String writer) {
        this.text = text;
        this.writer = writer;
    }
}
