package com.dox.events.model;

public class TeamMembers {

	
	public TeamMembers () {
		
	}
	
	private String name;

	public TeamMembers(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
