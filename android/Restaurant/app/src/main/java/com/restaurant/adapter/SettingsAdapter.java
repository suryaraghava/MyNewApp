package com.restaurant.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.restaurant.R;
import com.restaurant.model.Item;

import java.util.List;

/**
 * Created by Munisekhar on 1/25/2017.
 */
public class SettingsAdapter extends BaseAdapter{
    List<Item> list;
    private Context mContext;

    public SettingsAdapter(List<Item> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list.size();
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
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ImageView image;
        TextView nameTv,offerPriceTv,mrpPriceTv;
        CheckBox itemSelectCb;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.item_row, null);
        }
        nameTv = (TextView) convertView.findViewById(R.id.itemNameTv);
        offerPriceTv = (TextView) convertView.findViewById(R.id.offerPriceTv);
        mrpPriceTv = (TextView) convertView.findViewById(R.id.mrpPriceTv);

        nameTv.setText(list.get(position).getName());
        offerPriceTv.setText(list.get(position).getOfferPrice()+"");
        mrpPriceTv.setText(list.get(position).getMrpPrice()+"");
        mrpPriceTv.setPaintFlags(mrpPriceTv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        return  convertView;
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }
}
