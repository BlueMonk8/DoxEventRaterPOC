package com.dox.event.registration.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "judges")
public class Judges {

	public Judges () {
		
	}
	
	public Judges(String judge_id, String judge_name) {
		super();
		this.judge_id = judge_id;
		this.judge_name = judge_name;
	}
	public String getJudge_id() {
		return judge_id;
	}
	public void setJudge_id(String judge_id) {
		this.judge_id = judge_id;
	}
	public String getJudge_name() {
		return judge_name;
	}
	public void setJudge_name(String judge_name) {
		this.judge_name = judge_name;
	}
	@Id
	private String id;
	private String judge_id;	
	private String judge_name;
	
}
