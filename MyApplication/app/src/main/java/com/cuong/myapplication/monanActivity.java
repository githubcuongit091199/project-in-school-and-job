package com.cuong.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
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
import java.lang.String ;

import android.widget.TextView;

import com.cuong.myapplication.data.Gio;
import com.cuong.myapplication.data.TaiKhoan;
import com.cuong.myapplication.data.TongTien;
import com.cuong.myapplication.data.monanclass;

public class monanActivity extends AppCompatActivity {
    ListView lv_monnan;
    Button dangnhap, logout, tranggh;
    TextView lgtaikhoan;
    String urlmonan = "http://10.0.2.2:9090/api/monan/danhsachmonan";
    public static ArrayList<Gio> manggio;
    public  static TaiKhoan taikhoan;
    public  static ArrayList<TongTien> tongtien;
    String mail="";;
    ArrayList<monanclass> items = new ArrayList<monanclass>();
    MyService sv1 = new MyService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monan);
        AnhXa();

        sv1.execute();
        ActionClick();
        DieuKienDuLieu();
        SetViewLogin();

    }

    private void SetViewLogin() {
        mail=taikhoan.getTaikhoan();
        if(mail==null){
            dangnhap.setVisibility(View.VISIBLE);
            logout.setVisibility(View.INVISIBLE);
        }else {

            dangnhap.setVisibility(View.INVISIBLE);
            lgtaikhoan.setText(taikhoan.getTaikhoan());
            logout.setVisibility(View.VISIBLE);
        }
    }

    private void DieuKienDuLieu() {
        if(manggio!=null){//khác null ko cần tạo dữ liệu mới

        }else {//tạo cấp phát bộ nhớ mới
            manggio=new ArrayList<>();
        }
        if(taikhoan!=null){//khác null ko cần tạo dữ liệu mới

        }else {//tạo cấp phát bộ nhớ mới
            taikhoan=new TaiKhoan();
        }
        if(tongtien!=null){//khác null ko cần tạo dữ liệu mới

        }else {//tạo cấp phát bộ nhớ mới
            tongtien=new ArrayList<>();
        }
    }

    private void ActionClick() {

        lv_monnan.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent in = new Intent(monanActivity.this, chitietActivity.class);
                        Bundle bdct = new Bundle();//tìm item có id giống vs id
                        for (int i = 0; i < items.size(); i++) {
                            if (items.get(i).getId() == id) {
                                String str = items.get(i).getHinhanh();
                                String[] arrOfStr = str.trim().split(".jpg",2);
                                bdct.putDouble("giamonan", items.get(i).getGia());
                                bdct.putString("tenmonan", items.get(i).getTenmonan());
                                bdct.putString("ttmonan", items.get(i).getThongtin());
                                bdct.putString("hinhanhmonan", arrOfStr[0]);
                                bdct.putInt("idma", (int) id);
                                in.putExtras(bdct);
                                break;
                            }
                        }
                        startActivity(in);
                    }

                });
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail=taikhoan.getTaikhoan();
                if(mail==null){
                    dangnhap.setVisibility(View.VISIBLE);
                    Intent in = new Intent(monanActivity.this,loginActivity.class);
                    startActivity(in);
                }
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inload = new Intent(monanActivity.this,monanActivity.class);
                taikhoan.setTaikhoan(null);
                startActivity(inload);
            }
        });
        tranggh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ingh = new Intent(monanActivity.this,giohangActivity.class);
                startActivity(ingh);
            }
        });
    }

    private void AnhXa() {
        lv_monnan = findViewById(R.id.listproduct);
        dangnhap = findViewById(R.id.dangnhap);
        lgtaikhoan=findViewById(R.id.taikhoantxt);
        logout=findViewById(R.id.logout);
        tranggh=findViewById(R.id.dentranggh);

    }


    class MyService extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {

            URL url = null;
            HttpURLConnection connection = null;
            BufferedReader br = null;
            StringBuffer stringBuffer = new StringBuffer();
            try {
                url = new URL(urlmonan);
                Log.d("api", url + "");
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                int resCode = connection.getResponseCode();
                Log.d("apiá", resCode + "");

                if (resCode == HttpURLConnection.HTTP_OK) {

                    InputStream is = connection.getInputStream();
                    br = new BufferedReader(new InputStreamReader(is));
                    String s = br.readLine();
                    while (s != null) {
                        stringBuffer.append(s + "\n");
                        s = br.readLine();
                    }
                    if (stringBuffer.length() != 0) {
                        Log.d("apib", stringBuffer.toString());
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
                        String tenmonan = obj.getString("tenmonan");
                        String thongtin = obj.getString("thongtin");
                        String hinhanh = obj.getString("hinhanh");
                        Double gia = obj.getDouble("gia");
                        Integer id = obj.getInt("mamonan");
                        monanclass ma = new monanclass(tenmonan, thongtin, hinhanh, gia, id);
                        items.add(ma);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                monanAdapter adapter = new monanAdapter(monanActivity.this, items);
                lv_monnan.setAdapter(adapter);
            }
        }
    }
    class monanAdapter extends BaseAdapter {
        Context contextadapter;
        ArrayList<monanclass> monans;
        LayoutInflater inflater;

        public monanAdapter(Context contextadapter, ArrayList<monanclass> monans) {////////
            inflater = LayoutInflater.from(contextadapter);
            this.contextadapter = contextadapter;
            this.monans = monans;
        }

        @Override
        public int getCount() {
            return monans.size();
        }

        @Override
        public Object getItem(int position) {
            return monans.get(position);
        }

        @Override
        public long getItemId(int position) {
            return monans.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String str = monans.get(position).getHinhanh();
            int idma;
            String[] arrOfStr = str.trim().split(".jpg",2);
            convertView = inflater.inflate(R.layout.monanadapter, null);
            ImageView ima = convertView.findViewById(R.id.imamonan);
            TextView textmonan = convertView.findViewById(R.id.tenmonan);
            TextView texgia = convertView.findViewById(R.id.giamonan);
            textmonan.setText(monans.get(position).getTenmonan());
            texgia.setText(monans.get(position).getGia() + "");
            ima.setImageResource(getResources().getIdentifier(arrOfStr[0] ,"drawable","com.cuong.myapplication"));

            return convertView;
        }
    }
}
