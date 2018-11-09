package com.example.macbook.duan1.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macbook.duan1.Model.PhoneBook;
import com.example.macbook.duan1.R;

import java.util.List;

public class PhoneAdapter extends ArrayAdapter<PhoneBook> {
private Context context;
private  int resource;
private List<PhoneBook> objects;

    public PhoneAdapter( Context context, int resource,List<PhoneBook> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }


    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        ViewHolder viewHolder = null;
        convertView = LayoutInflater.from(context).inflate(R.layout.activity_item,parent,true);
        //viewHolder.mAvatar = convertView.findViewById(R.id.img);
       // viewHolder.mCall = convertView.findViewById(R.id.img_call);
       // viewHolder.mMess = convertView.findViewById(R.id.img_mess);
        viewHolder.mName = convertView.findViewById(R.id.tv_name);
        viewHolder.mPhone = convertView.findViewById(R.id.tv_phone);
      //  viewHolder.mSex = convertView.findViewById(R.id.tv_sex);
        PhoneBook context = objects.get(position);
        viewHolder.mName.setText(context.getmName());
        viewHolder.mPhone.setText(context.getmPhone());
//        if (context.isMsex()){
//            viewHolder.mSex.setText("boy");
//        }else {
//            viewHolder.mSex.setText("girl");
//        }

        return convertView;


    }
    public class ViewHolder{
        TextView mPhone , mName;
        //ImageView mAvatar,mCall,mMess;
       // TextView mPhone , mName ,mSex;
    }
}
