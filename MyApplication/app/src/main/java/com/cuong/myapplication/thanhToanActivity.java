package com.cuong.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

public class thanhToanActivity extends AppCompatActivity {
    TextView tk,sl,tongtien;
    Button xacnhantt;

    int mamonan, soluong;
    Double gia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        AnhXa();
        action();
    }

    private void action() {


        Log.d("logintag", "onClick: "+monanActivity.taikhoan.getTaikhoan());
        xacnhantt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                JSONArray jsonarray = new JSONArray();
                Intent inta1 = new Intent(thanhToanActivity.this, monanActivity.class);
                for (int i = 0; i < monanActivity.manggio.size(); i++) {





                        mamonan = monanActivity.manggio.get(i).getIdma();
                        soluong = monanActivity.manggio.get(i).getSoluong();
                        gia = monanActivity.manggio.get(i).getGiama();

                        JSONObject object = new JSONObject();
                        Log.d("vòng lặp for trong 1", "onClick: " + " " + i + " " + monanActivity.manggio.get(i).getSoluong());
                        try {

                            object.put("idmonan", monanActivity.manggio.get(i).getIdma());
                            object.put("email", monanActivity.taikhoan.getTaikhoan());
                            object.put("soLuong", monanActivity.manggio.get(i).getSoluong());


                            Log.d("vòng lặp for trong 2", "onClick: " + " " + i + " " + monanActivity.manggio.get(i).getSoluong());

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        new SendJsonDataToServer().execute(String.valueOf(jsonarray.put(object)));

                    }
                    monanActivity.manggio.clear();
                    monanActivity.tongtien.clear();
                    startActivity(inta1);

            }


        });
    }

    private void AnhXa() {
        tk=findViewById(R.id.tkgh);
        sl=findViewById(R.id.slgio);
        tongtien=findViewById(R.id.tongtien);
        xacnhantt=findViewById(R.id.btthanhtoan);
        tk.setText(monanActivity.taikhoan.getTaikhoan());
        int tongsl=0;
        for (int i = 0; i<monanActivity.manggio.size();i++){
            tongsl+=monanActivity.manggio.get(i).getSoluong();
        }
        sl.setText(String.valueOf(tongsl));
        Double tong = 0.0;
        for (int i =0;i<monanActivity.tongtien.size();i++){
            tong+=monanActivity.tongtien.get(i).getTongtien();
        }
        tongtien.setText(String.valueOf(tong));

    }
    private static class SendJsonDataToServer extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            String JsonResponse = null;
            String JsonDATA = params[0];

            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL("http://10.0.2.2:9090/api/monan/dulieugiohang");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setDoOutput(true);
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.setRequestProperty("Accept", "application/json");
                urlConnection.connect();


                //set headers and method
                Writer writer = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
                writer.write(JsonDATA);
                // json data
                writer.close();
                int resCode = urlConnection.getResponseCode();
                if (resCode == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = urlConnection.getInputStream();
//input stream
                    StringBuffer buffer = new StringBuffer();
                    if (inputStream == null) {
                        // Nothing to do.
                        return null;
                    }
                    reader = new BufferedReader(new InputStreamReader(inputStream));

                    String inputLine;
                    while ((inputLine = reader.readLine()) != null)
                        buffer.append(inputLine + "\n");
                    if (buffer.length() == 0) {
                        // Stream was empty. No point in parsing.
                        return null;
                    }
                    JsonResponse = buffer.toString();
//response data

                    Log.d("gui yeu cau", "doInBackground: ");
                    Log.i("SEND DATA POST", JsonResponse);
                    try {
//send to post execute
                        return JsonResponse;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return null;


            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("SEND DATA POST1", "Error closing stream", e);
                    }
                }
            }

            return null;

        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String responseData) {

            super.onPostExecute(responseData);
        }
    }

}