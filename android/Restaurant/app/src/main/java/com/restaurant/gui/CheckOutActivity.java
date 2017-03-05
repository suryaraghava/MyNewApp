package com.restaurant.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.restaurant.R;
import com.restaurant.gui.adapter.CheckOutAdapter;
import com.restaurant.model.AppContext;
import com.restaurant.model.Item;

import java.text.DecimalFormat;
import java.util.List;

public class CheckOutActivity extends AppCompatActivity implements CheckOutAdapter.CheckOutListener {

    ListView itemsLv;
    TextView totalPriceTv,noItemsTv;
    Button orderBtn;
    CheckOutAdapter adapter;
    DecimalFormat df = new DecimalFormat("#,###,##0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        itemsLv = (ListView) findViewById(R.id.itemsLv);
        totalPriceTv = (TextView) findViewById(R.id.totalPriceTv);
        noItemsTv = (TextView) findViewById(R.id.noItemsTv);
        orderBtn = (Button) findViewById(R.id.orderBtn);

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
    }

    @Override
    public void onItemChnage() {
        calculate();
    }
}
