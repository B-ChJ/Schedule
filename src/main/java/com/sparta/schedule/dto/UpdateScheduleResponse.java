package com.sparta.schedule.dto;

import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponse {

    private final Long id;
    private final String title;
    private final String registrant;
    private final LocalDateTime modifiedAt;

    public UpdateScheduleResponse(Long id, String title, String registrant, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.registrant = registrant;
        this.modifiedAt = modifiedAt;
    }
}
