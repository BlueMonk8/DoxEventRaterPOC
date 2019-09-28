package com.dox.event.ratings.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dox.event.ratings.model.RatedEvents;
import com.dox.event.ratings.model.RatedEventsList;
import com.dox.event.ratings.repo.EventRatingsRepo;

@RestController
@RequestMapping("doxEvent")
public class RatingEventResource {
   
	@Autowired
	EventRatingsRepo repository;
    
    @RequestMapping(value="/rateEvent", method = RequestMethod.GET)
    @ResponseBody
    public String loadSampleData () {
    
    	System.out.println("Rating Sample data of events");
    	
    	repository.save(new RatedEvents("e1",  "j1",  "t1", 10d));
    	repository.save(new RatedEvents("e1",  "j2",  "t1", 9d));
    	repository.save(new RatedEvents("e1",  "j3",  "t1", 8d));
    	
    	
    	repository.save(new RatedEvents("e1",  "j1",  "t2", 10d));
    	repository.save(new RatedEvents("e1",  "j2",  "t2", 10d));
    	repository.save(new RatedEvents("e1",  "j3",  "t2", 10d));
    	
    	repository.save(new RatedEvents("e1",  "j1",  "t3", 5d));
    	repository.save(new RatedEvents("e1",  "j2",  "t3", 5d));
    	repository.save(new RatedEvents("e1",  "j3",  "t3", 5d));
    	
    	repository.save(new RatedEvents("e1",  "j1",  "t4", 8d));
    	repository.save(new RatedEvents("e1",  "j2",  "t4", 9d));
    	repository.save(new RatedEvents("e1",  "j3",  "t4", 9d));
    	
    	
    	return "EVENT RATED WITH SUCCESS";
    }
    
    
    @RequestMapping("retrieveEvent/{eventId}")
    public RatedEventsList getEventRatings(@PathVariable("eventId") String eventId) {
    	
    	
    	return new RatedEventsList(repository.findRatedEventsById(eventId));
     }    
    
}
