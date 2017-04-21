package com.eriknj99.rhsapp2017.Data;

/**
 * Created by erik on 4/3/17.
 */

public class Announcement {

    private final String id;
    private final String title;
    private final String when;
    private final String where;
    private final String more;
    private final String endDate;

    //Basic (read only) data storage class

    public Announcement(String id, String title,String when, String where, String more, String endDate){
        this.id = id;
        this.title = title;
        this.when = when;
        this.where = where;
        this.more = more;
        this.endDate = endDate;
    }

    public String getID(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getWhen(){
        return when;
    }
    public String getWhere(){
        return where;
    }
    public String getMore(){
        return more;
    }
    public String getEndDate(){
        return endDate;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", when='" + when + '\'' +
                ", where='" + where + '\'' +
                ", more='" + more + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
