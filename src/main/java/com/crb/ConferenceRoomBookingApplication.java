package com.crb;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import com.crb.entity.MeetingRequest;
import com.crb.service.ConferenceRoomBookingService;

@SpringBootApplication
public class ConferenceRoomBookingApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ConferenceRoomBookingApplication.class);
	}
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ConferenceRoomBookingApplication.class, args);
		
		//Calling method to schedule
		ConferenceRoomBookingService cbrService = context.getBean(ConferenceRoomBookingService.class);
		//MeetingRequestRepository meetingRequestRepository = context.getBean(MeetingRequestRepository.class);
		//List<MeetingRequest> meetingRequests = meetingRequestRepository.findAllOrdered();//getting from H2 DB
		
		List<MeetingRequest> meetingRequests = cbrService.getMeetingRequestFromFile("D:\\Komal\\request.txt");//Getting from txt File
		
		cbrService.scheduleMeetings(meetingRequests);
	}

}
