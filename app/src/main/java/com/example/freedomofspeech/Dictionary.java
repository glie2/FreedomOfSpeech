package com.example.freedomofspeech;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Dictionary extends AsyncTask<String, Integer, String> {

    final String app_id = "7da47597";
    final String app_key = "02d7cff77f571e601bc6b3e74f6e410f";
    String myurl;
    Context context;

    boolean validity;


 //   private GameActivity guessBoxInstance;
   // public Dictionary(GameActivity a) {
  //      guessBoxInstance = a;
   // }

    Dictionary(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        myurl = params[0];
        try {

            URL url = new URL(myurl);

            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept","application/json");
            urlConnection.setRequestProperty("app_id",app_id);
            urlConnection.setRequestProperty("app_key",app_key);

            // read the output from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            Log.d("setting", "reached line 61");

            JSONObject js = new JSONObject(stringBuilder.toString());
            Log.d("setting", "reached line 79");
            validity = true;

            return stringBuilder.toString();

        }
        catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        String def;
  /*      try {


            JSONArray results = js.getJSONArray("results");

            JSONObject lEntries = results.getJSONObject(0);
            JSONArray laArray = lEntries.getJSONArray("lexicalEntries");

            JSONObject entries = laArray.getJSONObject(0);
            JSONArray e = entries.getJSONArray("entries");

            JSONObject jsonObject = e.getJSONObject(0);
            JSONArray sensesArray = jsonObject.getJSONArray("senses");

            JSONObject d = sensesArray.getJSONObject(0);
            JSONArray de = d.getJSONArray("definitions");



            def = de.getString(0);
            a.errorMessage.setText(def);
            Toast.makeText(context,def,Toast.LENGTH_SHORT).show();


        } catch (JSONException e) {

          //  e.printStackTrace();
        }*/
    }
}
