package com.restaurant.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.net.InetAddress;
import java.util.Map;

/**
 * Created by Munisekhar on 1/24/2017.
 */
public class Utils {

    public static String getIpAddress(Context context){
        WifiManager wm = (WifiManager) context.getSystemService(context.WIFI_SERVICE);
        String ip = android.text.format.Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        Log.i("","Ip Address *********************  "+ip);
        return ip;
    }
    public static void saveString(Context context,String key,String value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Constants.MY_PREFS_NAME, context.MODE_PRIVATE).edit();
        editor.putString(key,value);
        editor.commit();
    }
    public static void saveInt(Context context,String key,int value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Constants.MY_PREFS_NAME, context.MODE_PRIVATE).edit();
        editor.putInt(key,value);
        editor.commit();
    }

    public static void saveBoolean(Context context,String key,Boolean value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Constants.MY_PREFS_NAME, context.MODE_PRIVATE).edit();
        editor.putBoolean(key,value);
        editor.commit();
    }

    public static void saveString(Context context,Map<String,String> map) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Constants.MY_PREFS_NAME, context.MODE_PRIVATE).edit();
        for(Map.Entry<String,String> entry : map.entrySet()) {
            editor.putString(entry.getKey(),entry.getValue());
        }
        editor.commit();
    }
    public  static boolean clearData(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Constants.MY_PREFS_NAME, context.MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();
        return true;
    }

    public static String getString(Context context,String key) {
        SharedPreferences prefs = context.getSharedPreferences(Constants.MY_PREFS_NAME, context.MODE_PRIVATE);
        return prefs.getString(key, null);
    }
    public static Boolean getBoolean(Context context,String key) {
        SharedPreferences prefs = context.getSharedPreferences(Constants.MY_PREFS_NAME, context.MODE_PRIVATE);
        return prefs.getBoolean(key,false);
    }
    public static int getInt(Context context,String key) {
        SharedPreferences prefs = context.getSharedPreferences(Constants.MY_PREFS_NAME, context.MODE_PRIVATE);
        return prefs.getInt(key,-1);
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    public boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            return !ipAddr.equals("");
        } catch (Exception e) {
            return false;
        }

    }
    public static void showSnackBar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

    public static void logError(String tag,String message,Throwable throwable) {
        Log.e(tag,message,throwable);
    }

    public static void logInfo(String tag,String message) {
        Log.i(tag,message);
    }

    public static void startIntent(Context context,Class targetActivity) {
        Intent intent = new Intent(context,targetActivity);
        context.startActivity(intent);
    }

    public static void startIntentWIthClearTop(Context context,Class targetActivity) {
        Intent intent = new Intent(context,targetActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    /*public static void buildPopup(Context context, final Spinner spinner, final OnItemSelected selected) {
        List<String> dropdownItems = new ArrayList<>();
        dropdownItems.add(Utils.getString(context,Constants.USER_NAME_KEY));
        dropdownItems.add("Profile");
        dropdownItems.add("Logout");
        ArrayAdapter adapter = new ArrayAdapter(context,R.layout.item_tv,dropdownItems);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {

                } else if(position == 1){
                    spinner.setSelection(0);
                }
                spinner.setSelection(0);
                selected.selectedPos(position,view);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }*/

}
