package com.dox.event.registration.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.dox.event.registration.model.Members;

public interface MembersRepo extends MongoRepository<Members, String> {

	
    @Query("{team_id:'?0'}")
    List<Members> findMembersByTeamId(String teamId);
}
