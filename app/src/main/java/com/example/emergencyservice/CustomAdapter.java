package com.example.emergencyservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.datepicker.SingleDateSelector;

import java.util.ArrayList;
import java.util.Locale;

public class CustomAdapter extends BaseAdapter {

    int [] boy;
    String [] bloodDonar;
    String [] phoneNumber;
    String [] bloodGroup;
    Context context;
    LayoutInflater inflater;

    CustomAdapter(Context context,String [] bloodDonar,int [] boy,String [] phoneNumber,String [] bloodGroup){
        this.context=context;
        this.bloodDonar=bloodDonar;
        this.boy=boy;
        this.phoneNumber=phoneNumber;
        this.bloodGroup=bloodGroup;
    }

    @Override
    public int getCount() {
        return bloodDonar.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sample_view,parent,false);

        }

        ImageView imageView=convertView.findViewById(R.id.imageViewId);
        TextView textView=convertView.findViewById(R.id.bloodDonarId);
        TextView textView1=convertView.findViewById(R.id.phoneNumberId);
        TextView textView2=convertView.findViewById(R.id.bloodGroupId);


        imageView.setImageResource(boy[position]);
        textView.setText(bloodDonar[position]);
        textView1.setText(phoneNumber[position]);
        textView2.setText(bloodGroup[position]);


        return convertView;
    }


}
