package com.dox.event.registration.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "events")
public class Events {
	
	@Id
	private String id;
	private String event_id;	
	private String event_name;
	
	public Events() {
		
	}
	
	public Events(String event_id, String event_name) {
		
		this.event_id = event_id;
		this.event_name = event_name;
	}
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

}
