package com.restaurant.gui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.restaurant.R;
import com.restaurant.gui.adapter.OrderAdapter;
import com.restaurant.listener.OrderListener;
import com.restaurant.model.AppContext;
import com.restaurant.model.Item;

import java.text.DecimalFormat;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * to handle interaction events.
 * Use the {@link OrderFragment} factory method to
 * create an instancUtils
 HttpConnection
 Constantse of this fragment.
 */
public class OrderFragment extends Fragment implements View.OnTouchListener,OrderAdapter.CheckOutListener {
    ListView itemsLv;
    TextView totalPriceTv,backBtn,noItemsTv,cartCountTv;
    Button orderBtn;
    OrderAdapter adapter;
    DecimalFormat df = new DecimalFormat("#,###,##0.00");
    private OrderListener mListener;

    public OrderFragment() {
    }

    @Override
    public void onItemChnage() {
        calculate();
        mListener.onCartChange();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            switch (v.getId()) {
                case R.id.orderBtn:
                    showConfirmation();
                    break;
            }
        }
        return false;
    }

    private void showConfirmation() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("Order Confirmation");
        alertDialogBuilder.setMessage("Your subtotal is : "+totalPriceTv.getText());
        alertDialogBuilder.setPositiveButton("Order", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AppContext.getInstance().getMyOrders().addAll(AppContext.getInstance().getPlateItems());
                AppContext.getInstance().getPlateItems().clear();
                //Utils.showToast(CheckOutActivity.this,"Your order has been placed successfully.");
                mListener.onOrderClick();
                dialog.dismiss();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setCancelable(false);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order, container, false);
        itemsLv = (ListView) v.findViewById(R.id.itemsLv);
        totalPriceTv = (TextView) v.findViewById(R.id.totalPriceTv);
        orderBtn = (Button) v.findViewById(R.id.orderBtn);
        noItemsTv = (TextView) v.findViewById(R.id.noItemsTv);
        orderBtn.setOnTouchListener(this);
        adapter = new OrderAdapter(getActivity(),this);
        itemsLv.setAdapter(adapter);
        calculate();
        return v;
    }

    private void calculate() {
        List<Item> items = AppContext.getInstance().getPlateItems();
        if(items != null && items.size()>0) {
            itemsLv.setVisibility(View.VISIBLE);
            noItemsTv.setVisibility(View.GONE);

            double amount = 0;
            for (Item item:items) {
                amount = amount+(item.getCount()*item.getOfferPrice());
            }
            totalPriceTv.setText(""+df.format(amount)+" RS");

        } else {
            itemsLv.setVisibility(View.GONE);
            noItemsTv.setVisibility(View.VISIBLE);
            totalPriceTv.setText("0.00 RS");
        }
        noItemsTv.setText(""+AppContext.getInstance().getPlateItems().size());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OrderListener) {
            mListener = (OrderListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ScanListener");
        }
    }

    public OrderListener getmListener() {
        return mListener;
    }

    public void setmListener(OrderListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
