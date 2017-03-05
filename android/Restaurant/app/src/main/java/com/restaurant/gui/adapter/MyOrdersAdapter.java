package com.restaurant.gui.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.restaurant.R;
import com.restaurant.model.AppContext;
import com.restaurant.model.Item;

/**
 * Created by Munisekhar on 1/25/2017.
 */
public class MyOrdersAdapter extends BaseAdapter{
    private Context mContext;
    public MyOrdersAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return AppContext.getInstance().getMyOrders().size();
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
        TextView nameTv,offerPriceTv,mrpPriceTv,countTv,itemTotalTv,descTv;
        Button removeBtn,increaseBtn,decreaseBtn;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.my_order_row, null);
        }
        Item item = AppContext.getInstance().getMyOrders().get(position);

        image = (ImageView) convertView.findViewById(R.id.itemImg);
        nameTv = (TextView) convertView.findViewById(R.id.itemNameTv);
        offerPriceTv = (TextView) convertView.findViewById(R.id.offerPriceTv);
        mrpPriceTv = (TextView) convertView.findViewById(R.id.mrpPriceTv);
        countTv = (TextView) convertView.findViewById(R.id.countTv);
        itemTotalTv = (TextView) convertView.findViewById(R.id.itemTotalTv);
        descTv = (TextView) convertView.findViewById(R.id.itemDescTv);
        removeBtn = (Button) convertView.findViewById(R.id.removeBtn);
        increaseBtn = (Button) convertView.findViewById(R.id.increaseBtn);
        decreaseBtn = (Button) convertView.findViewById(R.id.decreaseBtn);
        mrpPriceTv.setPaintFlags(mrpPriceTv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        nameTv.setText(item.getName());
        offerPriceTv.setText(""+item.getOfferPrice());
        mrpPriceTv.setText(""+item.getMrpPrice());
        countTv.setText(""+item.getCount());
        itemTotalTv.setText(""+(item.getCount()*item.getOfferPrice()));
        descTv.setText("");

        removeBtn.setTag(position);
        increaseBtn.setTag(position);
        decreaseBtn.setTag(position);


        return  convertView;
    }


}
