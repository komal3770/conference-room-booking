package com.crb.service;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crb.entity.MeetingRequest;
import com.crb.entity.MeetingRoom;
import com.crb.repository.MeetingRequestRepository;
import com.crb.repository.MeetingRoomRepository;

@Service
public class ConferenceRoomBookingService {
	
	@Autowired
	MeetingRoomRepository meetingRoomRepository;
	
	@Autowired
	MeetingRequestRepository meetingRequestRepository;
	
	/**
	 * Schedule conference room meetings
	 * */
	public void scheduleMeetings(List<MeetingRequest> meetingRequests) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mma");
		try {

			// Conference Room Time in 24 hr format
			int roomBookStartHr = 9;
			int roomBookEndHr = 17;
			int lunchStartHr = 12;
			int lunchEndHr = 13;

			// Lunch Time
			LocalTime lunchStart = LocalTime.of(lunchStartHr, 0, 0, 0);
			LocalTime lunchEnd = LocalTime.of(lunchEndHr, 0, 0, 0);

			List<MeetingRoom> rooms = meetingRoomRepository.findAll();

			Iterator<MeetingRequest> meetingRequestItr = meetingRequests.iterator();

			// Allocating Meeting Rooms for meeting request received
			for (MeetingRoom room : rooms) {
				LocalTime time = LocalTime.of(roomBookStartHr, 0, 0, 0);
				System.out.println(room.getRoomName());

				while (meetingRequestItr.hasNext()) {
					// If room booking hour is not lying between 9 to 5
					if (time.getHour() < roomBookStartHr || time.getHour() >= roomBookEndHr)
						break;

					if (time.compareTo(lunchStart) >= 0 && time.compareTo(lunchEnd) < 0) {
						System.out.println(df.format(time) + " Lunch");
						time = lunchEnd;
					} else {
						MeetingRequest meetingRequest = meetingRequestItr.next();
						System.out.println(df.format(time) + "\t" + meetingRequest.getTitle() + " "+ meetingRequest.getDuration() + "min");
						time = time.plusMinutes(meetingRequest.getDuration());
						meetingRequestItr.remove();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reading From File
	 * */
	public List<MeetingRequest> getMeetingRequestFromFile(String fileName){
		List<MeetingRequest> talkList = new ArrayList<>();
        try {
            FileInputStream fstream = new FileInputStream(fileName);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = br.readLine();
            while (strLine != null) {
            	MeetingRequest request = new MeetingRequest();
            	
            	String talkTime = strLine.substring(strLine.lastIndexOf(' '));
            	talkTime = talkTime.substring(1, talkTime.length()-3);
            	
            	request.setTitle(strLine.substring(0, strLine.lastIndexOf(' ')));
            	request.setDuration(Integer.valueOf(talkTime));

                talkList.add(request);
                strLine = br.readLine();
            }
            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        Collections.sort(talkList);
        return talkList;
	}
	
}
