package NonTrivialSoftwareSystem;

import java.util.Date;
import java.util.LinkedList;

public class RideEvents {
    LinkedList<Event> AllEvents = new LinkedList<Event>();

    void AddEvent(Event e)
    {
        AllEvents.add(e);
    }

    public LinkedList<Event> getAllEvents() {
        return AllEvents;
    }

    void EventData()
    {
        for (Event e: AllEvents)
        {
            e.ShowEvent();
        }
    }
    int searchdate(Date d)
    {
        for (Event x :AllEvents) {
            if (d.compareTo(x.getEventtime())==0)
            {
                return d.compareTo(x.getEventtime());
            }
        }
        return -1;
    }
}
