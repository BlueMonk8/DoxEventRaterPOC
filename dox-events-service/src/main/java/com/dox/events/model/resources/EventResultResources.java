package com.dox.events.model.resources;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dox.events.model.EventWinners;
import com.dox.events.model.MembersList;
import com.dox.events.model.RatedEvents;
import com.dox.events.model.RatedEventsList;
import com.dox.events.model.Team;
import com.dox.events.model.TeamMembers;

@RestController
@RequestMapping("/doxEvent")
public class EventResultResources {

	
	  @Autowired
	  private RestTemplate restTemplate;
	  
	  
	  @RequestMapping("/eventWinners/{eventId}")
	    public EventWinners getEventWinners(@PathVariable("eventId") String eventId) {
		  
		  // finding the event which was rated : 
		  EventWinners  eventWinners = new EventWinners();
		  //RatedEventsList ratedEvent = restTemplate.getForObject("http://localhost:1905/doxEvent/retrieveEvent/" + eventId, RatedEventsList.class);
		  
		  //Using Eureka
		  RatedEventsList ratedEvent = restTemplate.getForObject("http://dox-event-rating-service/doxEvent/retrieveEvent/" + eventId, RatedEventsList.class);
		  
		  Map<String, Double> teamPoints = ratedEvent.getRatedEvents().stream().collect(Collectors.groupingBy(RatedEvents::getTeam_id, Collectors.summingDouble(RatedEvents::getRatings)));
		  
		  eventWinners.setEvent(eventId);
		  
		  teamPoints = teamPoints.entrySet().stream()
	                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(2)
	                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		  
		 
		  // parse top two teams only
		  
		  List <Team> winningTeams = new ArrayList<>();
		  
		  teamPoints.forEach((k,v)-> {
			  	int position = 1;
				System.out.println("Team : " + k + " Total Points : " + v + "  Position: "+position);
				Team team= new Team();
				team.setPosition(String.valueOf(position));
				team.setName(k);
				team.setTotalPoints(String.valueOf(v));
				
				// need to call the member list micro service to get winning team memmbers
				
				setWinningTeamMembers (team, k);
				
				winningTeams.add(team);
				++position;
				
			});
		  
		  eventWinners.setWinners(winningTeams);
		  
		  
		  
		  // find the team id which has highest point
		  
		  
		  return eventWinners;
	  }


	private void setWinningTeamMembers(Team team, String teamId) {	
		
		List <TeamMembers> teamMembers = new ArrayList<>();
		//MembersList memberList = restTemplate.getForObject("http://localhost:1906/doxEvent/retrieveTeamMembers/"+teamId,  MembersList.class);
		
		// Discovery client		
		MembersList memberList = restTemplate.getForObject("http://dox-event-registration-service/doxEvent/retrieveTeamMembers/"+teamId,  MembersList.class);
		
		memberList.getMembersList().forEach(member -> teamMembers.add(new TeamMembers(member.getMember_name())) );
		
		team.setTeamMembers(teamMembers);
	}
	  
}
