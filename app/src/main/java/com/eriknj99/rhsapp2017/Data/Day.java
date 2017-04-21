package com.eriknj99.rhsapp2017.Data;

import java.util.ArrayList;

/**
 * Created by erik on 4/19/17.
 */

public class Day {

    private final String id;
    private final String date;
    private final boolean isSchoolDay;
    private final String day;
    private final String message;
    private final String nextDate;
    private final String nextDateID;
    private final ArrayList<ScheduleItem> schedule;

    public Day(String id, String date, boolean isSchoolDay, String day, String message, String nextDate, String nextDateID, ArrayList<ScheduleItem> schedule) {
        this.id = id;
        this.date = date;
        this.isSchoolDay = isSchoolDay;
        this.day = day;
        this.message = message;
        this.nextDate = nextDate;
        this.nextDateID = nextDateID;
        this.schedule = schedule;
    }

    public String getId() {
        return id;
    }
    public String getDate() {
        return date;
    }
    public boolean isSchoolDay() {
        return isSchoolDay;
    }
    public String getDay() {
        return day;
    }
    public String getMessage() {
        return message;
    }
    public String getNextDate() {
        return nextDate;
    }
    public String getNextDateID() {
        return nextDateID;
    }
    public ArrayList<ScheduleItem> getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", isSchoolDay=" + isSchoolDay +
                ", day='" + day + '\'' +
                ", message='" + message + '\'' +
                ", nextDate='" + nextDate + '\'' +
                ", nextDateID='" + nextDateID + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}
