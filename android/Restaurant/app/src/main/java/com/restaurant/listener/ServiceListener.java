package com.restaurant.listener;

import android.view.View;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Munisekhar on 1/24/2017.
 */
public interface ServiceListener {
    public void onSuccess(int statusCode, Header[] headers, JSONObject response, View view, int position);
    public void onFailure(int statusCode, Throwable throwable, JSONObject object, View view, int position);

}
