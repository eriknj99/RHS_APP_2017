package com.eriknj99.rhsapp2017.Data;

/**
 * Created by erik on 4/3/17.
 */

public class ScheduleItem {
    private final String label;
    private final Boolean isPeriod;
    private final String start;
    private final String end;

    public ScheduleItem(String label, Boolean isPeriod, String start, String end) {
        this.label = label;
        this.isPeriod = isPeriod;
        this.start = start;
        this.end = end;
    }

    public String getLabel() {
        return label;
    }
    public Boolean getPeriod() {
        return isPeriod;
    }
    public String getStart() {
        return start;
    }
    public String getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "ScheduleItem{" +
                "label='" + label + '\'' +
                ", isPeriod=" + isPeriod +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
