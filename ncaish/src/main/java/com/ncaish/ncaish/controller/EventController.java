package com.ncaish.ncaish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncaish.ncaish.exception.EventNotFoundException;
import com.ncaish.ncaish.model.EventConfigEO;
import com.ncaish.ncaish.service.EventService;



@RestController
@RequestMapping("/notification")
public class EventController {

    @Autowired
    private EventService eventService;


    @GetMapping("/getAll")
    public List<EventConfigEO> getAll(){
        return eventService.getAll();
    }

   @GetMapping("/event/{event}")
   public EventConfigEO getByEvent(@PathVariable("event")String event) throws EventNotFoundException{
    return eventService.getByEvent(event);
   }


   @PostMapping("/add")
   public String addData(@RequestBody EventConfigEO event1){
    return eventService.addData(event1);
   }
   
   @PutMapping("/put/{event}")
   public String updatEvent(@PathVariable("event") String event,@RequestBody EventConfigEO event1) throws EventNotFoundException{
    return eventService.updatEvent(event,event1);
   }


   @DeleteMapping("/delete/{event}")
   public String deleteEvent(@PathVariable("event") String event) throws EventNotFoundException{
    return eventService.deleteEvent(event);
   }


    
}
