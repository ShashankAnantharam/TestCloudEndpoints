package com.example.shashank_pc.testcloudendpoints;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.shashank_pc.myapplication.backend.TempClassEndpoint;
import  com.example.shashank_pc.myapplication.backend.TempClass;
// import com.example.shashank_pc.myapplication.backend.tempClassApi.TempClassApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.appengine.repackaged.com.google.api.client.json.jackson2.JacksonFactory;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       try {

        //    TempClassEndpoint tempClassEndpoint = new TempClassEndpoint();
            TempClass temp = new TempClass();
        //    int x = temp.getA();
        //    Toast.makeText(getApplicationContext(),Integer.toString(x),Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),"Exception",Toast.LENGTH_SHORT).show();
        }

    }



 /*   private class Testtask extends AsyncTask<String,String,String> {


        @Override
        protected String doInBackground(String... params) {

            TempClassApi.Builder builder = new TempClassApi.Builder(
                    AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setHttpRequestInitializer(new HttpRequestInitializer() {
                        @Override
                        public void initialize(HttpRequest request) throws IOException {

                            TempClassEndpoint tempClassEndpoint = null;

                        }
                    });




            return null;
        }
    }*/
}
