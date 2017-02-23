package com.restaurant.gui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.restaurant.R;
import com.restaurant.listener.RestaurantDetailsListener;
import com.restaurant.listener.ScanListener;
import com.restaurant.model.AppContext;
import com.restaurant.model.FragmentEnum;
import com.restaurant.util.Utils;

import java.util.Map;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnTouchListener,ScanListener,RestaurantDetailsListener {
    private static String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        loadFragment(FragmentEnum.SCANFRAGMENT,null);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return false;
    }

    @Override
    public void onExpolreClick() {
        loadFragment(FragmentEnum.ITEMSFRAGMENT,null);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_camera) {
            loadFragment(FragmentEnum.SCANFRAGMENT, null);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(FragmentEnum selFrg, Map<String,String> params) {
        Fragment fragment = null;

        if (selFrg == FragmentEnum.SCANFRAGMENT) {
            fragment = new ScanFragment();
        } else if(selFrg == FragmentEnum.RESTAURANTDETAILSFRGMENT) {
            fragment = new RestaurantDetailsFragment();
        } else if(selFrg == FragmentEnum.ITEMSFRAGMENT) {
            fragment = new ItemsFragment();
        }
        if(params != null) {
            Bundle bundle = new Bundle();
            for(Map.Entry<String,String> entry:params.entrySet()) {
                bundle.putString(entry.getKey(),entry.getValue());
            }
            fragment.setArguments(bundle);
        }
        if(fragment != null){
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container,fragment);
            fragmentTransaction.commit();
        }
    }

    android.os.Handler qrCodeHandler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg){
            loadFragment(FragmentEnum.RESTAURANTDETAILSFRGMENT, null);
        }
    };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null && requestCode == 49374) {
            if (result.getContents() == null) {
                Utils.showToast(this,"Result Not Found");
            } else {
                try {
                    Utils.showToast(this,result.getContents());
                    AppContext.getInstance().setSelectedQRCode(result.getContents());
                    qrCodeHandler.sendEmptyMessage(0);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Utils.logError(TAG,ex.getMessage(),ex);
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
