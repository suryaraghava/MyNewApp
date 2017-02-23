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
import android.widget.TextView;
import android.widget.Toast;

import com.restaurant.R;
import com.restaurant.adapter.SettingsAdapter;
import com.restaurant.listener.RestaurantDetailsListener;
import com.restaurant.model.AppContext;
import com.restaurant.model.Item;
import com.restaurant.model.Restaurant;
import com.restaurant.util.Utils;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * to handle interaction events.
 * Use the {@link ItemsFragment} factory method to
 * create an instancUtils
 HttpConnection
 Constantse of this fragment.
 */
public class ItemsFragment extends Fragment implements View.OnTouchListener {
    ListView startersLv,mainCourseLv;
    SettingsAdapter startersAdapter,mainCourseAdapter;
    List<Item> startersList,mainCourseList;
    public ItemsFragment() {
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
        View v = inflater.inflate(R.layout.fragment_items, container, false);
        mainCourseLv = (ListView) v.findViewById(R.id.mainCourseLv);
        startersLv = (ListView) v.findViewById(R.id.startersLv);
        startersList = AppContext.getInstance().getItems().get(AppContext.getInstance().getSelectedQRCode()).get("Starters");
        mainCourseList = AppContext.getInstance().getItems().get(AppContext.getInstance().getSelectedQRCode()).get("Main Course");
        startersAdapter = new SettingsAdapter(startersList,getActivity());
        startersLv.setAdapter(startersAdapter);
        mainCourseAdapter = new SettingsAdapter(mainCourseList,getActivity());
        mainCourseLv.setAdapter(mainCourseAdapter);

        //Utils.showToast(getActivity(),"starters"+startersList.size()+" Main course"+mainCourseList.size());
        //Utils.showToast(getContext(),"QR Code"+ AppContext.getInstance().getSelectedQRCode());
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       /* if (context instanceof RestaurantDetailsListener) {
           // mListener = (RestaurantDetailsListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ScanListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

}
