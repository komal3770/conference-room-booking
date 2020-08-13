package com.crb.schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crb.repository.MeetingRequestRepository;
import com.crb.repository.MeetingRoomRepository;
import com.crb.repository.ScheduledMeetingRepository;

@Component
public class ScheduledTasks {
	
	@Autowired
	MeetingRoomRepository meetingRoomRepository;
	
	@Autowired
	MeetingRequestRepository meetingRequestRepository;
	
	@Autowired
	ScheduledMeetingRepository scheduledMeetingRepository;
	
	
	public void scheduleMeetings() {
		
	}
	
}
