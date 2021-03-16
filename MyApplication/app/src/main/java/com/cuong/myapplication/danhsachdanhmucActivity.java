package com.cuong.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class danhsachdanhmucActivity extends AppCompatActivity {

    String urlthucdon= "http://10.0.2.2:9090/api/monan/danhmuc";
    ListView lv_danhmuc;
    Button btthucdon;
    ArrayList <String> items = new ArrayList<String>();
    MyService sv = new MyService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachdanhmuc);
        lv_danhmuc= findViewById(R.id.listdanhmuc);
        lv_danhmuc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(danhsachdanhmucActivity.this, monanActivity.class);
                startActivity(in);
            }
        });
        btthucdon=findViewById(R.id.btdanhmuc);
        btthucdon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sv.execute();
            }
        });

    }
    class MyService extends AsyncTask<String ,String , String> {
        @Override
        protected String doInBackground(String... strings) {
            Log.d("api", "doInBackground");
            URL url=null;
            HttpURLConnection connection=null;
            BufferedReader br=null;
            StringBuffer stringBuffer=new StringBuffer();
            try {
                url =new URL(urlthucdon);
                Log.d("api", url+"");
                connection =(HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                int resCode = connection.getResponseCode();
                Log.d("api", resCode+"");

                if (resCode == HttpURLConnection.HTTP_OK) {

                    InputStream is = connection.getInputStream();
                    br = new BufferedReader(new InputStreamReader(is));
                    String s = br.readLine();
                    while (s!= null) {
                        stringBuffer.append(s + "\n");
                        s = br.readLine();
                    }
                    if(stringBuffer.length() !=0){
                        Log.d("api", stringBuffer.toString());
                        return stringBuffer.toString();
                }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                connection.disconnect();
                try {
                    if(br!=null)
                        br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;

        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s!=null) {
                //parse json
                try {
                    JSONArray root = new JSONArray(s);
                    for (int i = 0; i < root.length(); i++) {
                        JSONObject obj = root.getJSONObject(i);
                        String tendanhmuc = obj.getString("loaimonan");
                        items.add(tendanhmuc);
                    }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(danhsachdanhmucActivity.this, android.R.layout.simple_list_item_1,items);
                lv_danhmuc.setAdapter(adapter);
        }
    }
    }

}