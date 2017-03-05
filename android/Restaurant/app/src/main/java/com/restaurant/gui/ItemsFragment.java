package com.restaurant.gui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.restaurant.R;
import com.restaurant.gui.adapter.SettingsAdapter;
import com.restaurant.listener.ItemListener;
import com.restaurant.model.AppContext;
import com.restaurant.model.Item;

import java.util.List;
import java.util.Map;


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
    private ItemListener mListener;
    private LinearLayout itemsLv;
    private TextView noItemsTv;

    public ItemsFragment() {
    }


    public ItemListener getmListener() {
        return mListener;
    }

    public void setmListener(ItemListener mListener) {
        this.mListener = mListener;
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
        itemsLv = (LinearLayout) v.findViewById(R.id.itemsLv);
        noItemsTv = (TextView) v.findViewById(R.id.noItemsTv);
        Map<String, List<Item>> restaurentItems = AppContext.getInstance().getItems().get(AppContext.getInstance().getSelectedQRCode());
        if(restaurentItems != null) {
            startersList = AppContext.getInstance().getItems().get(AppContext.getInstance().getSelectedQRCode()).get("Starters");
            mainCourseList = AppContext.getInstance().getItems().get(AppContext.getInstance().getSelectedQRCode()).get("Main Course");
            noItemsTv.setVisibility(View.GONE);
            startersAdapter = new SettingsAdapter(startersList,getActivity(),mListener);
            startersLv.setAdapter(startersAdapter);
            mainCourseAdapter = new SettingsAdapter(mainCourseList,getActivity(),mListener);
            mainCourseLv.setAdapter(mainCourseAdapter);
        } else {
            noItemsTv.setVisibility(View.VISIBLE);
            itemsLv.setVisibility(View.GONE);
        }

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ItemListener) {
           // mListener = (ItemListener) context;
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
