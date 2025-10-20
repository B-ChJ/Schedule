package com.sparta.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //일정 id
    @Column(length = 30, nullable = false) // 한글은 3바이트
    private String title; //제목
    @Column(length = 200, nullable = false)
    private String content; //내용
    @Column(nullable = false)
    private String registrant; //작성자명
    @Column(nullable = false)
    private String password; //비밀번호

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public Schedule(String title, String content, String registrant, String password) {
        this.title = title;
        this.content = content;
        this.registrant = registrant;
        this.password = password;
    }
    public void addComment(Comment comment) {
        if(comments.size() >= 10) {
            throw new IllegalStateException("댓글은 최대 10개까지 등록할 수 있습니다.");
        }
        comments.add(comment);

    }

    public void update(String title, String registrant) {
        this.title = title;
        this.registrant = registrant;
    }
}
