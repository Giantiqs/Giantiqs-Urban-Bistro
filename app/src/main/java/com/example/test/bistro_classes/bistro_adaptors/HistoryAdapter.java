package com.example.test.bistro_classes.bistro_adaptors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.bistro_classes.bistro_domains.HistoryDomain;
import com.example.test.bistro_classes.bistro_domains.UsersDomain;

import java.util.ArrayList;

public class HistoryAdapter extends BaseAdapter {

    Context context;
    ArrayList<HistoryDomain> arrayList;

    public HistoryAdapter(Context context, ArrayList<HistoryDomain> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.bistro_viewholder_history, null);
        TextView orderId = convertView.findViewById(R.id.orderId),
                productName = convertView.findViewById(R.id.productName),
                quantity = convertView.findViewById(R.id.prodQuantity),
                date = convertView.findViewById(R.id.orderDate),
                time = convertView.findViewById(R.id.orderTime),
                fee = convertView.findViewById(R.id.orderFee);

        HistoryDomain historyDomain = arrayList.get(position);

        String orderId2 = String.valueOf(historyDomain.getId()),
                productName2 = historyDomain.getProductName(),
                qty = String.valueOf(historyDomain.getQuantity()),
                orderDate = historyDomain.getDate(),
                orderTime = historyDomain.getTime(),
                orderFee = String.valueOf(historyDomain.getFee());

        orderId.setText(orderId2);
        productName.setText(productName2);
        quantity.setText(qty);
        date.setText(orderDate);
        time.setText(orderTime);
        fee.setText(orderFee);

        return convertView;
    }
}
