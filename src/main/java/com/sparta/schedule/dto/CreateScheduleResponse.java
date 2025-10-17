package com.sparta.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {

    private final String title;
    private final String content;
    private final String registrant;
    private final String password;
//    private final LocalDateTime createdAt;
//    private final LocalDateTime modifiedAt;

    public CreateScheduleResponse(String title, String content, String registrant, String password) {
        this.title = title;
        this.content = content;
        this.registrant = registrant;
        this.password = password;
    }
}
