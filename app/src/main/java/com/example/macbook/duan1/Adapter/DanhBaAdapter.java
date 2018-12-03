package com.example.macbook.duan1.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
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

import com.example.macbook.duan1.model.ContactDAO;
import com.example.macbook.duan1.model.DanhBa;
import com.example.macbook.duan1.model.PhoneBook;
import com.example.macbook.duan1.R;

import java.io.ByteArrayOutputStream;
import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class DanhBaAdapter extends BaseAdapter implements Filterable {
    private Activity context;
    private ContactDAO contactDAO;
    private List<PhoneBook> contactList;
    private final int SELECT_PHOTO = 1;
    private List<DanhBa>danhBaList;
    private ArrayAdapter<DanhBa>danhBaAdapter;

    private final LayoutInflater inflater;

    public DanhBaAdapter(Activity context, List<DanhBa> contactList) {
        super();
        this.danhBaList = contactList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        contactDAO = new ContactDAO(context);
    }




    @Override
    public int getCount() {
        return danhBaList.size();
    }

    @Override
    public Object getItem(int i) {
        return danhBaList.get(i);
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

            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        DanhBa _entry = danhBaList.get(position);
        holder.mName.setText(_entry.getDbname());
        holder.mPhone.setText(_entry.getDbphone());
        return convertView;


    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public static class ViewHolder {
        TextView mPhone, mName ;
        ImageView mCall , mMess ;
    }


}
