package com.cuong.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;

import android.widget.Button;


import android.widget.ListView;
import android.widget.TextView;

import com.cuong.myapplication.adapter.giohangAdapter;


public class giohangActivity extends AppCompatActivity {

    String mail=null;
    ListView lv_giohang;
    static TextView giatri;
    Button thanhtoan;
    Button tieptucmua;
    TextView thongvao;
    com.cuong.myapplication.adapter.giohangAdapter giohangAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);
        AnhXa();
        CheckData();
        EventGio();
        EditGio();
        EvenThanhToan();
        chuyenTrang();

    }

    private void EvenThanhToan() {
        if(monanActivity.manggio.size()==0){
            thanhtoan.setVisibility(View.INVISIBLE);
        }else {
            thanhtoan.setVisibility(View.VISIBLE);
        }
    }


    private void chuyenTrang() {
        mail = monanActivity.taikhoan.getTaikhoan();
        if(mail==null){
            thanhtoan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent thanhtoan = new Intent(giohangActivity.this, loginActivity.class);
                    startActivity(thanhtoan);
                }
            });
        }else {
            thanhtoan.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent thanhtoan = new Intent(giohangActivity.this, thanhToanActivity.class);
                    startActivity(thanhtoan);
                }
            });
        }
        tieptucmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(giohangActivity.this, monanActivity.class);
                startActivity(in);
            }
        });
    }

    private void EditGio() {
        lv_giohang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(giohangActivity.this);//diaog
                builder.setTitle("Xác nhận xóa sản phẩm");
                builder.setMessage("Bạn có chắc muốn xóa sản phẩm này");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (monanActivity.manggio.size() <= 0) {
                            thongvao.setVisibility(View.VISIBLE);
                        } else {
                            monanActivity.manggio.remove(position);
                            monanActivity.tongtien.remove(position);
                            giohangAdapter.notifyDataSetChanged();
                            EventGio();
                            if(monanActivity.manggio.size()<=0){
                                thongvao.setVisibility(View.VISIBLE);
                            }else {
                                thongvao.setVisibility(View.INVISIBLE);
                                giohangAdapter.notifyDataSetChanged();
                                EventGio();
                            }
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        giohangAdapter.notifyDataSetChanged();
                        EventGio();
                    }
                });
                builder.show();
                return true;

            }
        });
    }
    public static void EventGio() {
        Double tongtien =0.0;
        for (int i =0;i<monanActivity.tongtien.size();i++) {

            tongtien += monanActivity.tongtien.get(i).getTongtien();
        }
        giatri.setText(String.valueOf(tongtien));


    }
    private void CheckData() {
        if(monanActivity.manggio.size()<=0){
            giohangAdapter.notifyDataSetChanged();
            thongvao.setVisibility(View.VISIBLE);
            lv_giohang.setVisibility(View.INVISIBLE);
        }else {
            giohangAdapter.notifyDataSetChanged();
            thongvao.setVisibility(View.INVISIBLE);
            lv_giohang.setVisibility(View.VISIBLE);
        }
    }

    private void AnhXa() {
 
        lv_giohang = findViewById(R.id.listgiohang);
        giatri = findViewById(R.id.giatri);
        thongvao=findViewById(R.id.thongbao);
        thanhtoan = findViewById(R.id.btthanhtoan1);
        tieptucmua = findViewById(R.id.bttieptucmuahang);
        giohangAdapter=new giohangAdapter(giohangActivity.this,monanActivity.manggio);
        lv_giohang.setAdapter(giohangAdapter);


    }
}


