package NonTrivialSoftwareSystem;

import java.util.Date;

///////////////////////////////////
public abstract class Event {
    private String Eventname;
    private Date Eventtime;

    public abstract String ShowEvent();

    public String getEventname() {
        return Eventname;
    }

    //
    public Event(String eventname, Date eventtime) {
        Eventname = eventname;
        Eventtime = eventtime;
    }

    public void setEventname(String eventname) {
        Eventname = eventname;
    }

    public Date getEventtime() {
        return Eventtime;
    }

    public void setEventtime(Date eventtime) {
        Eventtime = eventtime;
    }
}
