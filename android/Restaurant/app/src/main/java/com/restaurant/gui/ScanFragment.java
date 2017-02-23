package com.restaurant.gui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;
import com.restaurant.R;
import com.restaurant.listener.ScanListener;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * to handle interaction events.
 * Use the {@link ScanFragment} factory method to
 * create an instancUtils
 HttpConnection
 Constantse of this fragment.
 */
public class ScanFragment extends Fragment implements View.OnTouchListener {

    private IntentIntegrator qrScan;
    private Button scanBtn;

    private ScanListener mListener;

    public ScanFragment() {
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            qrScan.initiateScan();
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
        View v = inflater.inflate(R.layout.fragment_scan, container, false);
        scanBtn = (Button) v.findViewById(R.id.scanBtn);
        scanBtn.setOnTouchListener(this);
        qrScan = new IntentIntegrator(getActivity());
        qrScan.setBeepEnabled(false);
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
