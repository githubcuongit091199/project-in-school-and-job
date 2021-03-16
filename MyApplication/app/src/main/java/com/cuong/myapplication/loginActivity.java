package com.cuong.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cuong.myapplication.data.loginclass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class loginActivity extends AppCompatActivity {
    String urltaikhoan = "http://10.0.2.2:9090/api/monan/taikhoan";
    EditText emailt;
    EditText passt;
    Button btlogin;
    Bundle bd = new Bundle();
    ArrayList<loginclass> lgcl = new ArrayList<loginclass>();
    MyService1 sv1 = new MyService1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhxa();
        emailt.getText().toString();
        passt.getText().toString();
        sv1.execute();
        dangnhap();
    }


    private void anhxa() {
        emailt = findViewById(R.id.EmailAddress);
        passt = findViewById(R.id.Password);
        btlogin = findViewById(R.id.btlogin);
    }

    private void dangnhap() {
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ema12", "onClick: " + emailt.getText().toString());
                Intent in = new Intent(loginActivity.this, monanActivity.class);

                for (int i = 0; i < lgcl.size(); i++) {
                    Boolean ktpss = kiemtraPassword(passt.getText().toString().trim(), lgcl.get(i).getPassword());
                    Boolean ktma = kiemtraEmail(emailt.getText().toString().trim(), lgcl.get(i).getEmail());
                    Boolean ktltk=kiemtraLoaitk(lgcl.get(i).getLoaitaikhoan());
                    Log.d("ktlog", "onClick: " + ktma + ktpss + ktltk+" //////  "+lgcl.get(i).getLoaitaikhoan());
                    if (ktma == true && ktpss == true && ktltk==true) {

                        monanActivity.taikhoan.setTaikhoan(lgcl.get(i).getEmail());   Log.d("ket qua log", "onClick: "+ lgcl.get(i).getLoaitaikhoan());
                        startActivity(in);
                        break;

                    }
                }
            }
        });
    }

    class MyService1 extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {

            URL url = null;
            HttpURLConnection connection = null;
            BufferedReader br = null;
            StringBuffer stringBuffer = new StringBuffer();
            try {
                url = new URL(urltaikhoan);
                Log.d("apilog", url + "");
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                int resCode = connection.getResponseCode();
                Log.d("apilog1", "bbbb" + resCode + "");

                if (resCode == HttpURLConnection.HTTP_OK) {
                    InputStream is = connection.getInputStream();
                    br = new BufferedReader(new InputStreamReader(is));
                    String s = br.readLine();
                    while (s != null) {
                        stringBuffer.append(s + "\n");
                        s = br.readLine();
                    }
                    if (stringBuffer.length() != 0) {
                        Log.d("apilog2", "aaa" + stringBuffer.toString());
                        return stringBuffer.toString();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connection.disconnect();
                try {
                    if (br != null)
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
            if (s != null) {
                //parse json
                try {
                    JSONArray root = new JSONArray(s);
                    for (int i = 0; i < root.length(); i++) {
                        JSONObject obj = root.getJSONObject(i);
                        String emailapi = obj.getString("email");
                        String passwordapi = obj.getString("password");
                        Integer mataikhoanapi = obj.getInt("mataikhoan");
                        String loaitaikhoanapi = obj.getString("loaitaikhoan");
                        loginclass lg = new loginclass(emailapi, passwordapi, mataikhoanapi,loaitaikhoanapi);
                        lgcl.add(lg);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String getMD5(String input) {

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        byte[] messageDigest = md.digest(input.getBytes());
        return convertByteToHex1(messageDigest);
    }

    private String convertByteToHex1(byte[] data) {
        BigInteger number = new BigInteger(1, data);
        String hashtext = number.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

    private boolean kiemtraPassword(String pass, String pass2) {
        String pass1 = getMD5(pass);
        if (pass1.equals(pass2))
            return true;
        return false;
    }

    private boolean kiemtraEmail(String mail1, String mail2) {
        if (mail1.toLowerCase().equals(mail2.toLowerCase()))
            return true;
        return false;
    }
    private boolean kiemtraLoaitk(String loaitk) {

        if (loaitk.compareTo("khachhang")==0)
            return true;
        return false;
    }

}
