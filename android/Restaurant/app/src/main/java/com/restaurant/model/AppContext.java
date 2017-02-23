package com.restaurant.model;

/**
 * Created by Munisekhar on 2/23/2017.
 */
public class AppContext {
    private static AppContext context;
    private String selectedQRCode;
    private AppContext() {
    }

    public static AppContext getInstance() {
        if(context == null) {
            context = new AppContext();
        }
        return  context;
    }

    public String getSelectedQRCode() {
        return selectedQRCode;
    }

    public void setSelectedQRCode(String selectedQRCode) {
        this.selectedQRCode = selectedQRCode;
    }
}
