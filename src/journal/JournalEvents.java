package journal;

import java.util.ArrayList;
import java.util.List;

public class JournalEvents {

    public List<Event> events;

    public JournalEvents(){
        events = new ArrayList<>();
    }

    public void ajouterEvents(TypeEvent type, String description){
        events.add(new Event(type, description));
    }


    public void showJournal(){
        for (Event event : events){
            System.out.println(event);
        }
    }

}
