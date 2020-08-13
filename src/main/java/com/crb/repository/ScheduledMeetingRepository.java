package com.crb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crb.entity.ScheduledMeeting;
@Repository
public interface ScheduledMeetingRepository extends JpaRepository<ScheduledMeeting, Integer>{

}
