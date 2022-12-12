package com.ncaish.ncaish.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ncaish.ncaish.model.EventConfigEO;

@Repository
public interface  EventReposiitory extends MongoRepository <EventConfigEO,String >{

    EventConfigEO getByEvent(String event);

    EventConfigEO deleteByEvent(String event);
    
}
