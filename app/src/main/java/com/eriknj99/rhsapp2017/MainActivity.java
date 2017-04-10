package com.eriknj99.rhsapp2017;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.eriknj99.rhsapp2017.Data.Absence;
import com.eriknj99.rhsapp2017.Data.DataFetcher;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private static Context context;
    private static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context = getApplicationContext();


        //VVV This is just for testing JSON VVVV
        textView = (TextView)findViewById(R.id.textView);

        ArrayList<Absence> allAbsences = DataFetcher.getAllAbsences();

        textView.setText("");

        for(int i = 0; i < allAbsences.size(); i++){
            textView.append(allAbsences.get(i).getName() + "\n");

        }

    }

    public static Context getContext(){
        return context;
    }
}






