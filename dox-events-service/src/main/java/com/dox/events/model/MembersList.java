package com.dox.events.model;

import java.util.List;

public class MembersList {

	private List<Members> membersList;
	
	public MembersList () {
		
	}

	public MembersList(List<Members> membersList) {
		super();
		this.membersList = membersList;
	}

	public List<Members> getMembersList() {
		return membersList;
	}

	public void setMembersList(List<Members> membersList) {
		this.membersList = membersList;
	}
}
