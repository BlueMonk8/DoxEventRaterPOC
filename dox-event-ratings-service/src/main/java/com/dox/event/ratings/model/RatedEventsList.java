package com.dox.event.ratings.model;

import java.util.List;

public class RatedEventsList {

	public RatedEventsList() {
		
	}
	
	public RatedEventsList(List<RatedEvents> ratedEvents) {
		super();
		this.ratedEvents = ratedEvents;
	}

	private List<RatedEvents> ratedEvents;

	public List<RatedEvents> getRatedEvents() {
		return ratedEvents;
	}

	public void setRatedEvents(List<RatedEvents> ratedEvents) {
		this.ratedEvents = ratedEvents;
	}
}
