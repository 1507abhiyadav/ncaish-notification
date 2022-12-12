package com.ncaish.ncaish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncaish.ncaish.exception.EventFoundException;
import com.ncaish.ncaish.exception.EventNotFoundException;
import com.ncaish.ncaish.model.EventConfigEO;
import com.ncaish.ncaish.repository.EventReposiitory;

import io.sentry.Sentry;

@Service
public class EventServiceImp implements EventService{

    @Autowired
    private EventReposiitory eventReposiitory;

   //(1) get data ---->

    @Override
    public List<EventConfigEO> getAll() {
        return eventReposiitory.findAll();
    }

    @Override
    public EventConfigEO getByEvent(String event) throws EventNotFoundException {
       EventConfigEO eventConfigEO = eventReposiitory.getByEvent(event);
    try{
       if (eventConfigEO != null){
        return eventConfigEO;
       }else{
            throw new EventNotFoundException("Event not found with event :"+ event);
       }
    }catch (Exception e){
        Sentry.captureMessage(e.getMessage());
        return eventConfigEO;

    }


    }
    
    //(2)add data ---->

    @Override
    public String addData(EventConfigEO event1) {
        // System.out.println(event);
        // System.out.println(event1.getEvent());
        EventConfigEO eventConfigEO = eventReposiitory.getByEvent(event1.getEvent());
        try{
            if (eventConfigEO != null){
                // return "Event  already  exists";
                throw new EventFoundException("Event already exists :"+ event1.getEvent());

            }else{
            eventReposiitory.save(event1);
            return "Data  Sucessfully Addded";
            }
        }catch(Exception e){
            Sentry.captureMessage(e.getMessage());
            return e.getMessage();
        }    
    }


    //(3) update data ---->

    // @Override
    // public Event updatEvent(String event) {
    //     Event resEvent = eventReposiitory.getByEvent(event);
    //     System.out.println(resEvent);
    //     resEvent.setEmail(true);
    //     resEvent.setPush(true);
    //     resEvent.setSms(true);
    //     resEvent.setSubject("data of detax card");
    //     resEvent.setEmailTemplate("Hi,<otp> is your OTP. Don't share the OTP with anyone - De'Tax Solutions");
    //     resEvent.setScreen("the page of detax card");
    //     resEvent.setArchive("detax cord notification");
    //     return eventReposiitory.save(resEvent);
    // }

    @Override
    public String updatEvent(String event, EventConfigEO event1) throws EventNotFoundException {
        // System.out.println(event);
        // System.out.println(event1);
        EventConfigEO resEvent = eventReposiitory.getByEvent(event);
    try{
        if (resEvent != null){
            resEvent.setEmail(event1.isEmail()); 
            resEvent.setArchive(event1.isArchive());
            // resEvent.setHtml(event1.isHtml());
            resEvent.setEmailTemplate(event1.getEmailTemplate()); 
            resEvent.setPush(event1.isPush());
            resEvent.setSms(event1.isSms());
            resEvent.setSubject(event1.getSubject());
            resEvent.setScreen(event1.getScreen());

            // return eventReposiitory.save(resEvent);
            eventReposiitory.save(resEvent);
            return "Data Successfuly Update";

        }else{
            throw new EventNotFoundException("Event not found with event :"+  event);
        }
    }catch(Exception e){
        Sentry.captureMessage(e.getMessage());
        return e.getMessage();
    }
}
    


    //(4) delete data  ----->

    @Override
    public String deleteEvent(String event) throws EventNotFoundException {
        // return eventReposiitory.deleteByEvent(event);
        EventConfigEO resEvent = eventReposiitory.getByEvent(event);
        try{
            if (resEvent != null){
            eventReposiitory.deleteByEvent(event);
            return "Data Successfully Delete";
            }else{
                throw new EventNotFoundException("Event not found with event :"+ event);
            }
        }catch(Exception e){
            Sentry.captureMessage(e.getMessage());
            return e.getMessage();
        }

    }

    
    
}
