package com.dox.event.registration.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "members")
public class Members {

	public Members () {
		
	}
	
	public Members(String member_id, String member_name, String team_id) {
		super();
		this.member_id = member_id;
		this.member_name = member_name;
		this.team_id = team_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	@Id
	private String id;
	private String member_id;	
	private String member_name;
	private String team_id;
}
