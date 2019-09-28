package com.dox.events.model;

import java.util.List;

public class Team {

	private String name;
	private String position;
	private String totalPoints;
	private List<TeamMembers> teamMembers;
	
	public Team () {
		
	}
	
	public Team(String name, String position, String totalPoints, List<TeamMembers> teamMembers) {
		super();
		this.name = name;
		this.position = position;
		this.totalPoints = totalPoints;
		this.teamMembers = teamMembers;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(String totalPoints) {
		this.totalPoints = totalPoints;
	}

	public List<TeamMembers> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<TeamMembers> teamMembers) {
		this.teamMembers = teamMembers;
	}
}
