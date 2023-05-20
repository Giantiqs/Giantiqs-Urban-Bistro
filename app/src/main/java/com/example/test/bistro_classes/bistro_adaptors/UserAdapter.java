package com.example.test.bistro_classes.bistro_adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.bistro_classes.bistro_domains.UsersDomain;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {

    static public String userNow = "";
    Context context;
    ArrayList<UsersDomain> users;

    public UserAdapter(Context context, ArrayList<UsersDomain> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflate.inflate(R.layout.user_holder, null);
        TextView username = convertView.findViewById(R.id.nameHolder);
        UsersDomain this_user = users.get(position);
        String name = this_user.getUsername();
        username.setText(name);

        return convertView;
    }
}
