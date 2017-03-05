package com.restaurant.gui.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.restaurant.R;
import com.restaurant.listener.ItemListener;
import com.restaurant.model.AppContext;
import com.restaurant.model.Item;

import java.util.List;

/**
 * Created by Munisekhar on 1/25/2017.
 */
public class CheckOutAdapter extends BaseAdapter{
    private Context mContext;
    private CheckOutListener mListener;
    public CheckOutAdapter(Context mContext,CheckOutListener mListener) {
        this.mContext = mContext;
        this.mListener = mListener;
    }

    @Override
    public int getCount() {
        return AppContext.getInstance().getPlateItems().size();
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
            convertView = inflater.inflate(R.layout.check_out_row, null);
        }
        Item item = AppContext.getInstance().getPlateItems().get(position);

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

        nameTv.setText(item.getName());
        offerPriceTv.setText(""+item.getOfferPrice());
        mrpPriceTv.setText(""+item.getMrpPrice());
        countTv.setText(""+item.getCount());
        itemTotalTv.setText(""+(item.getCount()*item.getOfferPrice()));
        descTv.setText("");

        removeBtn.setTag(position);
        increaseBtn.setTag(position);
        decreaseBtn.setTag(position);

        removeBtn.setOnTouchListener(onTouchListener);
        increaseBtn.setOnTouchListener(onTouchListener);
        decreaseBtn.setOnTouchListener(onTouchListener);

        return  convertView;
    }

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                int position = (Integer) v.getTag();
                Item item = AppContext.getInstance().getPlateItems().get(position);
                switch (v.getId()) {
                    case R.id.removeBtn:
                        AppContext.getInstance().getPlateItems().remove(item);
                        break;
                    case R.id.increaseBtn:
                           AppContext.getInstance().getPlateItems().get(position).setCount(item.getCount()+1);
                        break;
                    case R.id.decreaseBtn:
                        if(item.getCount() <= 0) {
                            return false;
                        }
                        AppContext.getInstance().getPlateItems().get(position).setCount(item.getCount()-1);
                        break;
                }
                mListener.onItemChnage();
                notifyDataSetChanged();
            }
            return false;
        }
    };

    public interface  CheckOutListener {
        void onItemChnage();
    }


}
