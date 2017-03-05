package com.restaurant.gui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.restaurant.R;
import com.restaurant.gui.adapter.CheckOutAdapter;
import com.restaurant.model.AppContext;
import com.restaurant.model.Item;
import com.restaurant.util.Utils;

import java.text.DecimalFormat;
import java.util.List;

public class CheckOutActivity extends AppCompatActivity implements CheckOutAdapter.CheckOutListener,View.OnTouchListener {

    ListView itemsLv;
    TextView totalPriceTv,backBtn,noItemsTv,cartCountTv;
    Button orderBtn;
    CheckOutAdapter adapter;
    DecimalFormat df = new DecimalFormat("#,###,##0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        itemsLv = (ListView) findViewById(R.id.itemsLv);
        totalPriceTv = (TextView) findViewById(R.id.totalPriceTv);
        orderBtn = (Button) findViewById(R.id.orderBtn);
        backBtn = (TextView) findViewById(R.id.backBtn);
        noItemsTv = (TextView) findViewById(R.id.noItemsTv);
        cartCountTv = (TextView) findViewById(R.id.cartCountTv);
        cartCountTv.setText(""+AppContext.getInstance().getPlateItems().size());
        orderBtn.setOnTouchListener(this);
        backBtn.setOnTouchListener(this);
        adapter = new CheckOutAdapter(this,this);
        itemsLv.setAdapter(adapter);
        calculate();

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
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            switch (v.getId()) {
                case R.id.orderBtn:
                        showConfirmation();
                    break;
                case R.id.backBtn:
                    this.finish();
                    break;
            }
        }
        return false;
    }

    private void showConfirmation() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Order Confirmation");
        alertDialogBuilder.setMessage("Your subtotal is : "+totalPriceTv.getText());
        alertDialogBuilder.setPositiveButton("Order", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AppContext.getInstance().getMyOrders().addAll(AppContext.getInstance().getPlateItems());
                AppContext.getInstance().getPlateItems().clear();
                CheckOutActivity.this.finish();
                Utils.showToast(CheckOutActivity.this,"Your order has been placed successfully.");
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
    public void onItemChnage() {
        calculate();
    }
}
