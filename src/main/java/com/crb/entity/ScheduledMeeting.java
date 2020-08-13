package com.crb.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ScheduledMeeting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer scheduledMeetingId;
	
	private Integer scheduledTime;
	private Integer requestId;
	private Date createdDate;
	
	public Integer getScheduledMeetingId() {
		return scheduledMeetingId;
	}
	public void setScheduledMeetingId(Integer scheduledMeetingId) {
		this.scheduledMeetingId = scheduledMeetingId;
	}
	public Integer getScheduledTime() {
		return scheduledTime;
	}
	public void setScheduledTime(Integer scheduledTime) {
		this.scheduledTime = scheduledTime;
	}
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
