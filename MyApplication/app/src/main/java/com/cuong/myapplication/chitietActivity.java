package com.cuong.myapplication;

import  androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.cuong.myapplication.data.Gio;
import com.cuong.myapplication.data.TongTien;


public class chitietActivity extends AppCompatActivity {

    TextView tenmonan;
    TextView gia;
    TextView ttmonan;
    Spinner spsoluong   ;
    ImageView hinhanh;
    Button btthemvaogiohang;
    Bundle bd;
    int idma=0;
    String stenmonan="";
    Double sgiama=0.0;
    String anh="";
    int soluong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet);
        AnhXa();

        EventThemVaoGio();
        SpinerSoLuong();
        GetDuLieu();


    }



    private void AnhXa() {
        tenmonan = findViewById(R.id.tensp);
        ttmonan = findViewById(R.id.textmota);
        gia = findViewById(R.id.giasp);
        hinhanh = findViewById(R.id.anh);
        btthemvaogiohang = findViewById(R.id.btthemgiohang);
        spsoluong = findViewById(R.id.spiner);

    }

    private void GetDuLieu() {
        Intent in = getIntent();
        bd = in.getExtras();

        if (in != null) {
            if (bd != null) {
                gia.setText(String.valueOf(bd.getDouble("giamonan")));
                tenmonan.setText(bd.getString("tenmonan"));
                ttmonan.setText(bd.getString("ttmonan"));
                hinhanh.setImageResource(getResources().getIdentifier(bd.getString("hinhanhmonan"), "drawable", "com.cuong.myapplication"));
                stenmonan = bd.getString("tenmonan");
                sgiama = bd.getDouble("giamonan");
                anh = bd.getString("hinhanhmonan");
                idma = bd.getInt("idma");

            }
        }
    }
    private void SpinerSoLuong() {
        Integer[] soluong= new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayAdapter=new ArrayAdapter<Integer>(this,R.layout.colorspin,soluong);
        spsoluong.setAdapter(arrayAdapter);

    }
    private void EventThemVaoGio() {
            btthemvaogiohang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (monanActivity.manggio.size() > 0 ) {
                        int sl=Integer.parseInt( String.valueOf(spsoluong.getSelectedItem()));

                        boolean thoat=false;
                        for (int i = 0 ; i <monanActivity.manggio.size();i++){
                            if (monanActivity.manggio.get(i).getIdma()==idma){
                                monanActivity.manggio.get(i).setSoluong(monanActivity.manggio.get(i).getSoluong()+sl);
                                if(monanActivity.manggio.get(i).getSoluong()>=10){
                                    monanActivity.manggio.get(i).setSoluong(10);
                                }
                                monanActivity.tongtien.get(i).setTongtien(sgiama*monanActivity.manggio.get(i).getSoluong());
                                thoat=true;
                            }
                        }
                        if(thoat==false){
                            int soluong = Integer.parseInt(String.valueOf(spsoluong.getSelectedItem()));
                            Double giasp = soluong*sgiama;
                            monanActivity.manggio.add(new Gio(idma,stenmonan,sgiama,anh,soluong));
                            monanActivity.tongtien.add(new TongTien(giasp));
                        }
                    }else {
                        int soluong = Integer.parseInt(String.valueOf(spsoluong.getSelectedItem()));
                        Log.d("TAG", "onClicksoluogn: " + soluong );
                        Double giasp = soluong*sgiama;
                        monanActivity.manggio.add(new Gio(idma,stenmonan,sgiama,anh,soluong));
                        monanActivity.tongtien.add(new TongTien(giasp));
                    }
                    Intent intogh = new Intent(chitietActivity.this, giohangActivity.class);
                    startActivity(intogh);
                }
            });


}}

