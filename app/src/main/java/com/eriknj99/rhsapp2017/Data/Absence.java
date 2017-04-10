package com.eriknj99.rhsapp2017.Data;

/**
 * Created by erik on 4/3/17.
 */

public class Absence {

    // Instance Vars based on JSON vars
    private String name;
    private String id;
    private String periods;
    private String assignment;

    //This class will store all information on an absent teacher and will be used by UI Controllers.

    public Absence(String name, String id, String periods, String assignment){
        this.name = name;
        this.id = id;
        this.periods = periods;
        this.assignment = assignment;
    }

    public String getName(){
        return name;
    }
    public String getID(){
        return id;
    }
    public String getPeriod(){
        return periods;
    }
    public String getAssignment(){
        return assignment;
    }



}
