package com.dox.event.registration.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dox.event.registration.model.Events;
import com.dox.event.registration.model.Judges;
import com.dox.event.registration.model.Members;
import com.dox.event.registration.model.MembersList;
import com.dox.event.registration.model.Teams;
import com.dox.event.registration.repo.EventsRepo;
import com.dox.event.registration.repo.JudgesRepo;
import com.dox.event.registration.repo.MembersRepo;
import com.dox.event.registration.repo.TeamsRepo;

@RestController
@RequestMapping("/doxEvent")
public class EventRegisterResource {

	
	@Autowired
	EventsRepo eventsRepo;
	
	@Autowired
	JudgesRepo judgesRepo;
	
	@Autowired
	TeamsRepo teamsRepo;
	
	@Autowired
	MembersRepo membersRepo;
	
    @RequestMapping(value="/registerEvent", method = RequestMethod.GET)
    @ResponseBody
    public String loadSampleData () {
    
    	System.out.println("Registraton of Sample data for rated events");
    	
    	
    	eventsRepo.save(new Events("e1", "DOX DANCE"));
    	eventsRepo.save(new Events("e2", "DOX SINGING"));
    	eventsRepo.save(new Events("e3", "DOX MUSIC"));
    	eventsRepo.save(new Events("e4", "DOX ORIGAMI"));
    	eventsRepo.save(new Events("e5", "DOX RANGOLI"));
    	
    	judgesRepo.save(new Judges ("j1", "ZEUS"));
    	judgesRepo.save(new Judges ("j2", "ARES"));
    	judgesRepo.save(new Judges ("j3", "HADES"));
    	judgesRepo.save(new Judges ("j4", "ATHENA"));
    	
    	
    	teamsRepo.save(new Teams ("t1", "TEAM KRISHNA"));
    	teamsRepo.save(new Teams ("t2", "TEAM SHIVA"));
    	teamsRepo.save(new Teams ("t3", "TEAM BRAHMA"));
    	teamsRepo.save(new Teams ("t4", "TEAM GANESHA"));
    	
    	membersRepo.save(new Members("m1", "Stoney", "t1"));
    	membersRepo.save(new Members("m2", "Gaurav", "t1"));
    	membersRepo.save(new Members("m3", "Navdeep", "t2"));
    	membersRepo.save(new Members("m4", "Suchika", "t2"));
    	membersRepo.save(new Members("m5", "Pravin", "t3"));
    	membersRepo.save(new Members("m6", "Pratik", "t3"));
    	membersRepo.save(new Members("m7", "Anil", "t4"));
    	membersRepo.save(new Members("m8", "Namratta", "t4"));
    	membersRepo.save(new Members("m9", "Mohmadi", "t4"));
    	
    	return "Event Registration Done Successfully";
    }
    
    
    @RequestMapping("retrieveTeamMembers/{teamId}")
    public MembersList getTeamMembers(@PathVariable("teamId") String teamId) {
    	
    	return new MembersList (membersRepo.findMembersByTeamId(teamId)); 
     } 
}
