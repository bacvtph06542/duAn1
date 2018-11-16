package com.example.macbook.duan1.Adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.macbook.duan1.Model.ContactDAO;
import com.example.macbook.duan1.Model.DanhBa;
import com.example.macbook.duan1.Model.PhoneBook;
import com.example.macbook.duan1.R;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class PhoneAdapter extends BaseAdapter implements Filterable {
    private Activity context;
    private ContactDAO contactDAO;
    List<PhoneBook> contactList;
    private final int SELECT_PHOTO = 1;
    List<PhoneBook> listSort;
    private ArrayList<DanhBa>danhBaList;
    private ArrayAdapter<DanhBa>danhBaAdapter;

    private final LayoutInflater inflater;




    public PhoneAdapter(Activity context, List<PhoneBook> contactList) {
        super();
        this.contactList = contactList;
        this.listSort = contactList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        contactDAO = new ContactDAO(context);
    }


    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @NonNull
    @Override
    public View getView( int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.activity_item,parent,false);


            holder.mCall = convertView.findViewById(R.id.img_call);
            holder.mCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent call = new Intent();
                    call.setAction(Intent.ACTION_CALL);
                    call.setData(Uri.parse("tel:"+holder.mPhone.getText()));
                    context.startActivity(call);
                    if (ActivityCompat.checkSelfPermission(context,Manifest.permission.CALL_PHONE)
                            != PackageManager.PERMISSION_GRANTED){
                    }
                }
            });

           holder.mMess = convertView.findViewById(R.id.img_mess);
           holder.mMess.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent mess = new Intent();
                   mess.setAction(Intent.ACTION_SENDTO);
                   mess.setData(Uri.parse("sms:"+holder.mPhone.getText()));
                   context.startActivity(mess);
               }
           });


            holder.mName = convertView.findViewById(R.id.tv_name);
            holder.mPhone = convertView.findViewById(R.id.tv_phone);

            holder.mImg =  convertView.findViewById(R.id.img);
            holder.mImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent camera = new Intent(Intent.ACTION_PICK);
                    camera.setType("image/*");
                    startActivityForResult(context , camera ,SELECT_PHOTO,null);
                }


            });

            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        PhoneBook _entry = contactList.get(position);
        holder.mName.setText(_entry.getmName());
        holder.mPhone.setText(_entry.getmPhone());
        return convertView;


    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public static class ViewHolder {
        TextView mPhone, mName ;
        ImageView mCall , mMess , mImg;
    }


}
