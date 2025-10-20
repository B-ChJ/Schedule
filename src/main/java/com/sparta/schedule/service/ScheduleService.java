package com.sparta.schedule.service;

import com.sparta.schedule.ScheduleDto.*;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    //CREATE
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(request.getTitle(),
                request.getContent(),
                request.getRegistrant(),
                request.getPassword());

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponse(savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getRegistrant(),
                savedSchedule.getPassword());
    }

    //READ
    //전체 조회
    @Transactional(readOnly = true)
    public List<GetScheduleResponse> getAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<GetScheduleResponse> allSchedules = new ArrayList<>();

        for (Schedule schedule : schedules) {
            GetScheduleResponse dto = new GetScheduleResponse(schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getRegistrant(),
                    schedule.getComments(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt());
            allSchedules.add(dto);
        }

        return allSchedules;
    }
    // 작성자명 검색 조회
    @Transactional(readOnly = true)
    public List<GetScheduleResponse> getByRegistrant(String registrant) {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<GetScheduleResponse> searchedSchedules = new ArrayList<>();

        for (Schedule schedule : schedules) {
            if (schedule.getRegistrant().equals(registrant)) {
                GetScheduleResponse dto = new GetScheduleResponse(schedule.getId(),
                        schedule.getTitle(),
                        schedule.getContent(),
                        schedule.getRegistrant(),
                        schedule.getComments(),
                        schedule.getCreatedAt(),
                        schedule.getModifiedAt());
                searchedSchedules.add(dto);
            }
        }
        return searchedSchedules;
    }
    //단 건 조회
    @Transactional(readOnly = true)
    public GetScheduleResponse getOne(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다."));

        return new GetScheduleResponse(schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getRegistrant(),
                schedule.getComments(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt());
    }
    //UPDATE
    @Transactional
    public UpdateScheduleResponse update(Long id, UpdateScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다."));
        if(!(schedule.getPassword().equals(request.getPassword()))) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        schedule.update(request.getTitle(), request.getRegistrant());

        return new UpdateScheduleResponse(schedule.getId(),
                schedule.getTitle(),
                schedule.getRegistrant(),
                schedule.getModifiedAt());
    }
    //DELETE
    @Transactional
    public void delete(Long id, DeleteScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다."));

        if(!(schedule.getPassword().equals(request.getPassword()))) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        scheduleRepository.deleteById(id);
    }

}

