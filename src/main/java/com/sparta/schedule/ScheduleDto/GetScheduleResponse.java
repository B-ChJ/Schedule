package com.sparta.schedule.ScheduleDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetScheduleResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String registrant;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public GetScheduleResponse(Long id, String title, String content, String registrant,
                               LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.registrant = registrant;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
