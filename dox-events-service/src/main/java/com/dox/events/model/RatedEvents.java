package com.dox.events.model;

import org.springframework.data.annotation.Id;

public class RatedEvents {
	
	@Id
	private String id;
	private String event_id;
	private String judge_id;
	private String team_id;
	private Double ratings;

	public RatedEvents() {
		
	}
	
	public RatedEvents(String event_id, String judge_id, String team_id, Double ratings) {
	
		this.setEvent_id(event_id);
	
		this.judge_id = judge_id;

		this.team_id = team_id;

		this.ratings = ratings;
	}

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	


	public String getJudge_id() {
		return judge_id;
	}

	public void setJudge_id(String judge_id) {
		this.judge_id = judge_id;
	}



	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}


	public Double getRatings() {
		return ratings;
	}

	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}

}
