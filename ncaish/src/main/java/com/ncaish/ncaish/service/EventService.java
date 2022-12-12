package com.ncaish.ncaish.service;

import java.util.List;

import com.ncaish.ncaish.exception.EventNotFoundException;
import com.ncaish.ncaish.model.EventConfigEO;

public interface EventService {

  // Get
    List<EventConfigEO> getAll();

    EventConfigEO getByEvent(String event) throws EventNotFoundException;

// Add
    // EventConfigEO addData(EventConfigEO event1);
    String addData(EventConfigEO event1);

// Update    
    // EventConfigEO deleteEvent(String event) throws EventNotFoundException;
    String deleteEvent(String event) throws EventNotFoundException;

// Delete
    // EventConfigEO updatEvent(String event, EventConfigEO event1) throws EventNotFoundException;
    String updatEvent(String event, EventConfigEO event1) throws EventNotFoundException;


    
}
