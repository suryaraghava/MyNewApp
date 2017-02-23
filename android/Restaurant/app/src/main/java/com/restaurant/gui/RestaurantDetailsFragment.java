package com.restaurant.gui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.restaurant.R;
import com.restaurant.listener.RestaurantDetailsListener;
import com.restaurant.listener.ScanListener;
import com.restaurant.model.AppContext;
import com.restaurant.util.Utils;


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

    public RestaurantDetailsFragment() {
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {

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
