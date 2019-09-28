package com.dox.event.registration.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teams")
public class Teams {

	public Teams () {
		
	}
	
	public Teams(String team_id, String team_name) {
		super();
		this.team_id = team_id;
		this.team_name = team_name;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	@Id
	private String id;
	private String team_id;	
	private String team_name;
}
