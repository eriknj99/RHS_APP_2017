package com.eriknj99.rhsapp2017;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.eriknj99.rhsapp2017.Data.Absence;
import com.eriknj99.rhsapp2017.Data.Announcement;
import com.eriknj99.rhsapp2017.Data.DataFetcher;
import com.eriknj99.rhsapp2017.ExpandableListView.CustomExpandableListAdapter;
import com.eriknj99.rhsapp2017.ExpandableListView.ExpandableListDataPump;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.R.attr.button;


public class MainActivity extends AppCompatActivity {


    private static Context context;

    Button absBtn;
    Button ansBtn;
    Button schBtn;

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context = getApplicationContext();

        final ArrayList<Absence> absences = DataFetcher.getAllAbsences();
        final ArrayList<Announcement> announcements = DataFetcher.getAllAnnouncement();

        initABSListView(savedInstanceState, absences);

        final Bundle INSTANCE_STATE = savedInstanceState;



        absBtn = (Button) findViewById(R.id.btnAbs);
        absBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                initABSListView(INSTANCE_STATE, absences);

            }
        });

        ansBtn = (Button) findViewById(R.id.btnAns);
        ansBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                initANSListView(INSTANCE_STATE, announcements);
            }
        });

    }

    //Temp method move this to a UI controller
    private void initABSListView(Bundle savedInstanceState, ArrayList<Absence> absences){
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.insertAbsenceData(absences);
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);


        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                return false;
            }
        });
    }

    private void initANSListView(Bundle savedInstanceState, ArrayList<Announcement> announcements){
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.insertAnnouncementData(announcements);
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);


        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                return false;
            }
        });
    }

    public static Context getContext(){
        return context;
    }
}






