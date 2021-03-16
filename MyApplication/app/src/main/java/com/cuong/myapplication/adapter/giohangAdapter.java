package com.cuong.myapplication.adapter;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cuong.myapplication.R;
import com.cuong.myapplication.data.Gio;
import com.cuong.myapplication.giohangActivity;
import com.cuong.myapplication.monanActivity;

import java.util.ArrayList;


public class giohangAdapter extends BaseAdapter {
    Context context;
    ArrayList<Gio> arrayGiohang;

    public giohangAdapter(Context context, ArrayList<Gio> arrayGiohang) {
        this.context = context;
        this.arrayGiohang = arrayGiohang;
    }

    @Override
    public int getCount() {
        return arrayGiohang.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayGiohang.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewGio{
        public TextView tenma,giama;
        public ImageView anhgh;
        public Button  incre,soluongval,decre;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewGio viewGio = null;
        if (convertView == null){
            viewGio=new ViewGio();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.activity_giohang_adapter,null);
            viewGio.tenma=convertView.findViewById(R.id.tenspgio);
            viewGio.giama=convertView.findViewById(R.id.giaspgio);
            viewGio.anhgh=convertView.findViewById(R.id.anhgiohang);
            viewGio.incre=convertView.findViewById(R.id.bttangsl);
            viewGio.decre=convertView.findViewById(R.id.btgiamsl);
            viewGio.soluongval=convertView.findViewById(R.id.btsoluong);
            convertView.setTag(viewGio);
        }else {
            viewGio= (ViewGio) convertView.getTag();

            }
            Gio gio = (Gio) getItem(position); //khởi tạo clss giỏ hàng
        viewGio.tenma.setText(gio.getTenma());

        viewGio.giama.setText(String.valueOf(monanActivity.manggio.get(position).getGiama()));
        viewGio.anhgh.setImageResource(convertView.getResources().getIdentifier(gio.getHinhma(),"drawable","com.cuong.myapplication"));
        viewGio.soluongval.setText(String.valueOf(gio.getSoluong()));
        int sl= Integer.parseInt(String.valueOf(viewGio.soluongval.getText()));
        if(sl>=10){
            viewGio.incre.setVisibility(View.INVISIBLE);
            viewGio.decre.setVisibility(View.VISIBLE);
        }else if(sl<= 1){
            viewGio.decre.setVisibility(View.INVISIBLE);
        }else if(sl>=1){
            viewGio.incre.setVisibility(View.VISIBLE);
            viewGio.decre.setVisibility(View.VISIBLE);
        }
        final ViewGio finalViewGio = viewGio;
        viewGio.incre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soluongmoi=Integer.parseInt(String.valueOf(finalViewGio.soluongval.getText()))+1;
                int soluonght= monanActivity.manggio.get(position).getSoluong();
                Double giaht=monanActivity.tongtien.get(position).getTongtien();
                monanActivity.manggio.get(position).setSoluong(soluongmoi);
                Double giamoi=(giaht*soluongmoi)/soluonght;
                monanActivity.tongtien.get(position).setTongtien(giamoi);
                giohangActivity.EventGio();
                if(soluongmoi>9){
                    finalViewGio.incre.setVisibility(View.INVISIBLE);
                    finalViewGio.decre.setVisibility(View.VISIBLE);
                    finalViewGio.soluongval.setText(String.valueOf(soluongmoi));
                }else {
                    finalViewGio.incre.setVisibility(View.VISIBLE);
                    finalViewGio.decre.setVisibility(View.VISIBLE);
                    finalViewGio.soluongval.setText(String.valueOf(soluongmoi));
                }
            }
        });
        viewGio.decre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soluongmoi=Integer.parseInt(String.valueOf(finalViewGio.soluongval.getText())) -1;
                int soluonght= monanActivity.manggio.get(position).getSoluong();
                Double giaht=monanActivity.tongtien.get(position).getTongtien();
                monanActivity.manggio.get(position).setSoluong(soluongmoi);
                Double giamoi=(giaht*soluongmoi)/soluonght;
                monanActivity.tongtien.get(position).setTongtien(giamoi);
                giohangActivity.EventGio();
                if(soluongmoi<2){
                    finalViewGio.incre.setVisibility(View.VISIBLE);
                    finalViewGio.decre.setVisibility(View.INVISIBLE);
                    finalViewGio.soluongval.setText(String.valueOf(soluongmoi));
                }else {
                    finalViewGio.incre.setVisibility(View.VISIBLE);
                    finalViewGio.decre.setVisibility(View.VISIBLE);
                    finalViewGio.soluongval.setText(String.valueOf(soluongmoi));
                }

            }
        });
        return convertView;
    }
}