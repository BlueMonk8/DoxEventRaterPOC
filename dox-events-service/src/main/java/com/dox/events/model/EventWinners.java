package com.dox.events.model;

import java.util.List;

public class EventWinners {
	
	private String event;
	private List<Team> winners;
	
	public EventWinners () {
		
	}
	
	public EventWinners(String event, List<Team> winners) {
		super();
		this.event = event;
		this.setWinners(winners);
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}

	public List<Team> getWinners() {
		return winners;
	}

	public void setWinners(List<Team> winners) {
		this.winners = winners;
	}

}
