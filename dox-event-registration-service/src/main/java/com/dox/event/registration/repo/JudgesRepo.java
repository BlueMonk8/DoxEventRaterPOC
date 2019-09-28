package com.dox.event.registration.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.dox.event.registration.model.Judges;

public interface JudgesRepo extends MongoRepository<Judges, String> {

	
    @Query("{judge_id:'?0'}")
    List<Judges> findJudgesById(String judgeId);
}
