package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId, Integer.MAX_VALUE);
        calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public ArrayList<Meeting> getCalendar() {
        return calendar;
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

        if (calendar.size() == 0) {
            return 0;
        }

        Collections.sort(calendar, (a, b) -> {
            return a.getEndTime().isAfter(b.getEndTime()) == true ? 1 : -1;
        });

        int count = 1;
        LocalTime last = calendar.get(0).getEndTime();
        for (int i = 1; i < calendar.size(); i++) {
            LocalTime start = calendar.get(i).getStartTime();
            if (start.isAfter(last) || start.equals(last)) {
                count++;
                last = calendar.get(i).getEndTime();
            }
        }
        return count;
    }
}
