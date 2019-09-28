package com.dox.event.registration.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.dox.event.registration.model.Events;

public interface EventsRepo extends MongoRepository<Events, String> {

	
    @Query("{event_id:'?0'}")
    List<Events> findEventsById(String eventId);
}
