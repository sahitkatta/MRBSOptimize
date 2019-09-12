package com.comakeit.mrbs.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.comakeit.mrbs.constants.Status;

@Entity
@Table(name = "MeetingRequest")
public class MeetingRequest {
	@Id
	@Column(length=20)
	private String requestId;
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	@Enumerated(EnumType.STRING)
	@Column(length=15)
	private Status status;
	private LocalDateTime requestedOn;
	@ManyToOne(targetEntity = Resource.class, fetch = FetchType.EAGER)
	private Resource resource;
	@ManyToOne(targetEntity = Login.class, fetch = FetchType.EAGER)
	private Login user;
	@ManyToOne(targetEntity = MeetingRoom.class, fetch = FetchType.EAGER)
	private MeetingRoom meetingRoom;
    
	

	public LocalDateTime getRequestedOn() {
		return requestedOn;
	}

	public String getRequestId() {
		return requestId;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public Login getUser() {
		return user;
	}

	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public Resource getResource() {
		return resource;
	}

	public Status getStatus() {
		return status;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public void setUser(Login user) {
		this.user = user;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setRequestedOn(LocalDateTime requestedOn) {
		this.requestedOn = requestedOn;
	}

}
