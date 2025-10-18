package com.sparta.schedule.ScheduleDto;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {

    private String title;
    private String content;
    private String registrant;
    private String password;
}
