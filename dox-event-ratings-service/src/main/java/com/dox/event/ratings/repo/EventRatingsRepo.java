package com.dox.event.ratings.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.dox.event.ratings.model.RatedEvents;

public interface EventRatingsRepo extends MongoRepository<RatedEvents, String> {

	
    @Query("{event_id:'?0'}")
    List<RatedEvents> findRatedEventsById(String eventId);
}
