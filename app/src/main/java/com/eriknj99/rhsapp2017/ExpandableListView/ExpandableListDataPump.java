package com.eriknj99.rhsapp2017.ExpandableListView;

import com.eriknj99.rhsapp2017.Data.Absence;
import com.eriknj99.rhsapp2017.Data.Announcement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {

    //this method takes an arraylist of Absences and formats them correctly into a hash map of List<String>
    public static HashMap<String, List<String>> insertAbsenceData(ArrayList<Absence> allAbsences)  {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();


        for(int i = 0; i < allAbsences.size(); i++){
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(allAbsences.get(i).getPeriod());
            temp.add(allAbsences.get(i).getAssignment());

            expandableListDetail.put(allAbsences.get(i).getName(), temp);

        }

        return expandableListDetail;
    }

    public static HashMap<String, List<String>> insertAnnouncementData(ArrayList<Announcement> allAbsences)  {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();


        for(int i = 0; i < allAbsences.size(); i++){
            ArrayList<String> temp = new ArrayList<String>();
            if(!allAbsences.get(i).getWhen().equals(""))
                temp.add(allAbsences.get(i).getWhen());

            if(!allAbsences.get(i).getWhere().equals(""))
                temp.add(allAbsences.get(i).getWhere());

            if(!allAbsences.get(i).getMore().equals(""))
                temp.add(allAbsences.get(i).getMore());


            expandableListDetail.put(allAbsences.get(i).getTitle(), temp);

        }

        return expandableListDetail;
    }
}
