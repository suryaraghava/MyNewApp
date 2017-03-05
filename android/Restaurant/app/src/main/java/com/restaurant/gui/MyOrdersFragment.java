package com.restaurant.gui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.restaurant.R;
import com.restaurant.gui.adapter.MyOrdersAdapter;
import com.restaurant.listener.ScanListener;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * to handle interaction events.
 * Use the {@link MyOrdersFragment} factory method to
 * create an instancUtils
 HttpConnection
 Constantse of this fragment.
 */
public class MyOrdersFragment extends Fragment implements View.OnTouchListener {



    private ScanListener mListener;
    private MyOrdersAdapter adapter;
    private ListView myOrdersLv;
    public MyOrdersFragment() {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_orders, container, false);
        myOrdersLv = (ListView) v.findViewById(R.id.myOrdersLv);
        adapter = new MyOrdersAdapter(getActivity());
        myOrdersLv.setAdapter(adapter);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ScanListener) {
            mListener = (ScanListener) context;
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
