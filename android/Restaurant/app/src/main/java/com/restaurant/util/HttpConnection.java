package com.restaurant.util;


import android.content.Context;
import android.view.View;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.restaurant.R;
import com.restaurant.listener.ServiceListener;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;


/**
 * Created by Munisekhar on 1/23/2017.
 */
public class HttpConnection {

    private ServiceListener listener;
    private Context context;
   public HttpConnection(ServiceListener listener, Context context) {
        this.listener = listener;
        this.context = context;
   }

   public void doPost(JSONObject object, String urlPath,final View view,final int position) throws  Exception{
        if(Utils.isNetworkConnected(context)) {
            Utils.logInfo("","Web service request \n URL : "+context.getString(R.string.url) + context.getString(R.string.context_path) + urlPath+" \n Boday : "+object);
            AsyncHttpClient client = new AsyncHttpClient();
            client.setConnectTimeout(1000);
            StringEntity entity = new StringEntity(object.toString());
            client.post(context, context.getString(R.string.url) + context.getString(R.string.context_path) + urlPath, entity, "application/json", new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    listener.onSuccess(statusCode, headers, response, view, position);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    listener.onFailure(statusCode, throwable, errorResponse, view, position);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    listener.onFailure(statusCode, throwable, null, view, position);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                    listener.onFailure(statusCode, throwable, null, view, position);
                }

            });
        } else {
            Utils.showSnackBar(view,"Please check your network connection and try again.");
        }
   }

}
