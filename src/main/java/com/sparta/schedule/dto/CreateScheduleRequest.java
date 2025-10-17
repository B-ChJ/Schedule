package com.sparta.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleRequest {

    private String title;
    private String content;
    private String registrant;
    private String password;
}
