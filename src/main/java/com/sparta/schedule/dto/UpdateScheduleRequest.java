package com.sparta.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleRequest {

    private String title;
    private String registrant;
    private String password;
    private LocalDateTime modifiedAt;
}
