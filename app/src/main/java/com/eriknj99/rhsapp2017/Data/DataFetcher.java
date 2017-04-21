package com.eriknj99.rhsapp2017.Data;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by erik on 4/3/17.
 */

//This class handles ALL of the json fetching and parsing ONLY call getter methods from the main thread.

public class DataFetcher {

    private static final String ABSENCE_URL = "http://app.ridgewood.k12.nj.us/api/rhs/absences.php";
    private static final String ANNOUNCEMENT_URL = "http://app.ridgewood.k12.nj.us/api/rhs/announcements.php";
    private static final String SCHEDULE_URL = "http://app.ridgewood.k12.nj.us/api/rhs/dashboard.php";

    //Will return an arrayList of Absence to be used in the UI
    public static ArrayList<Absence> getAllAbsences(){
        ArrayList<Absence> out = new ArrayList<Absence>();
        JSONObject object = getJSONObjectFromNewThread(ABSENCE_URL);

        if(object != null) {
            try {
                for (int i = 0; i < object.getJSONArray("absences").length(); i++) {
                    JSONObject temp = object.getJSONArray("absences").getJSONObject(i);
                    out.add(new Absence(
                            temp.get("name").toString(),
                            //This is the only way that I could parse out the 2D array in the json it probably is not the best solution.
                            new JSONObject(new JSONArray(temp.get("info").toString()).get(0).toString()).get("id").toString(),
                            new JSONObject(new JSONArray(temp.get("info").toString()).get(0).toString()).get("periods").toString(),
                            new JSONObject(new JSONArray(temp.get("info").toString()).get(0).toString()).get("assignment").toString()
                            ));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return out;
    }

    //Parses Json into an arraylist of announcements
    public static ArrayList<Announcement> getAllAnnouncement(){
        ArrayList<Announcement> out = new ArrayList<Announcement>();
        JSONObject object = getJSONObjectFromNewThread(ANNOUNCEMENT_URL);

        if(object != null){
            try {
                for (int i = 0; i < object.getJSONArray("announcements").length(); i++) {
                    JSONObject temp = object.getJSONArray("announcements").getJSONObject(i);
                    out.add(new Announcement(
                            temp.get("id").toString(),
                            temp.get("title").toString(),
                            temp.get("when").toString(),
                            temp.get("where").toString(),
                            temp.get("more").toString(),
                            temp.get("endDate").toString()
                            ));
                }
            }   catch (JSONException e) {
            e.printStackTrace();
            }
        }

        return out;
    }

    public static Day getCurrentDay(){
        Day d = null;
        JSONObject object = getJSONObjectFromNewThread(SCHEDULE_URL);

        ArrayList<ScheduleItem> items = new ArrayList<ScheduleItem>();
        if(object != null){
            try{

                for(int i = 0; i < object.getJSONArray("schedule").length(); i++){
                    JSONObject temp = object.getJSONArray("schedule").getJSONObject(i);
                    items.add(new ScheduleItem(
                            temp.get("label").toString(),
                            Boolean.parseBoolean(temp.get("isPeriod").toString()),
                            temp.get("start").toString(),
                            temp.get("end").toString()));
                }

                d = new Day(
                        object.get("id").toString(),
                        object.get("date").toString(),
                        Boolean.parseBoolean(object.get("isSchoolDay").toString()),
                        object.get("day").toString(),
                        object.get("message").toString(),
                        object.get("nextDate").toString(),
                        object.get("nextDayId").toString(),
                        items);

            }catch(JSONException e){
                e.printStackTrace();
            }
        }

        return d;
    }


        //Automatically reads json object from JSONThread and returns the result
        private static JSONObject getJSONObjectFromNewThread(String url){
            JSONThread j = new JSONThread(url);
            Thread t = new Thread(j);
            t.start();
                try {
                    t.join();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

        return j.getValue();
    }
        private static String readAll(Reader rd) throws IOException {
            StringBuilder sb = new StringBuilder();
            int cp;
                while ((cp = rd.read()) != -1) {
                    sb.append((char) cp);
                }
            return sb.toString();

        }
        //DO NOT CALL THIS METHOD FROM MAIN THREAD!!!
        public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
            InputStream is = new URL(url).openStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String jsonText = readAll(rd);
                JSONObject json = new JSONObject(jsonText);

                return json;
            } finally {
                is.close();
            }
        }
    }


    //This class opens a new thread that calls readJSONFromURL in order to prevent crashing
class JSONThread implements Runnable {
    private volatile JSONObject value;
    private volatile String url;


        public JSONThread(String url){
            this.url = url;
        }

    @Override
    public void run() {
        if(url != null) {
            try {
                JSONObject json = DataFetcher.readJsonFromUrl(url);
                value = json;
            } catch (Exception e) {
                e.printStackTrace();
                Log.i("***ERROR***","FAILED TO READ JSON FROM URL: " + url );
            }
        }
    }

    public JSONObject getValue() {
        return value;
    }

}




