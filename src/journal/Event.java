package journal;

import java.time.LocalDateTime;

public class Event {
    private LocalDateTime date;
    private TypeEvent typeEvent;
    private String description;

    public Event(TypeEvent typeEvent, String description){
        this.date = LocalDateTime.now();
        this.typeEvent = typeEvent;
        this.description = description;
    }

    public String toString(){
        return "["+ date +"]" + "["+typeEvent + "] : " + description;
    }



}
