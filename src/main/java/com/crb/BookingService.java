package com.crb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crb.entity.ScheduledMeeting;
import com.crb.repository.MeetingRequestRepository;
import com.crb.repository.MeetingRoomRepository;
import com.crb.repository.ScheduledMeetingRepository;

@Service
public class BookingService {
	@Autowired
	MeetingRoomRepository meetingRoomRepository;
	
	@Autowired
	MeetingRequestRepository meetingRequestRepository;
	
	@Autowired
	ScheduledMeetingRepository scheduledMeetingRepository;
	
	
}
