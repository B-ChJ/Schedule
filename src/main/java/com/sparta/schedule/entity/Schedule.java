package com.sparta.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

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

    public Schedule(String title, String content, String registrant, String password) {
        this.title = title;
        this.content = content;
        this.registrant = registrant;
        this.password = password;
    }

    public void update(String title, String content, String registrant, String password) {
        this.title = title;
        this.content = content;
        this.registrant = registrant;
        this.password = password;
    }
}
