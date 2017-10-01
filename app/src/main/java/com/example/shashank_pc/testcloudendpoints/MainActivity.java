package com.example.shashank_pc.testcloudendpoints;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    private class Testtask extends AsyncTask<String,String,String> {


        @Override
        protected String doInBackground(String... params) {

            
            return null;
        }
    }
}
