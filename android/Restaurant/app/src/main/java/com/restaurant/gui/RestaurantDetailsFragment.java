package com.restaurant.gui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.restaurant.R;
import com.restaurant.listener.RestaurantDetailsListener;
import com.restaurant.listener.ScanListener;
import com.restaurant.model.AppContext;
import com.restaurant.model.Restaurant;
import com.restaurant.util.Utils;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * to handle interaction events.
 * Use the {@link RestaurantDetailsFragment} factory method to
 * create an instancUtils
 HttpConnection
 Constantse of this fragment.
 */
public class RestaurantDetailsFragment extends Fragment implements View.OnTouchListener {

    private RestaurantDetailsListener mListener;
    private TextView restTv;
    private Button exploreBtn;
    public RestaurantDetailsFragment() {
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            switch (v.getId()) {
                case R.id.exploreBtn:
                        mListener.onExpolreClick();
                    break;
            }
        }
        return false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_details, container, false);
        restTv = (TextView) v.findViewById(R.id.restTv);
        exploreBtn = (Button)v.findViewById(R.id.exploreBtn);
        Restaurant restaurant = AppContext.getInstance().getRestaurants().get(AppContext.getInstance().getSelectedQRCode());
        if(restaurant != null) {
            restTv.setText(restaurant.getName());
            exploreBtn.setOnTouchListener(this);
        } else {
            restTv.setText("No Data Found!");
            exploreBtn.setClickable(false);
            exploreBtn.setEnabled(false);
        }
        Utils.showToast(getContext(),"QR Code"+ AppContext.getInstance().getSelectedQRCode());
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof RestaurantDetailsListener) {
            mListener = (RestaurantDetailsListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ScanListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
