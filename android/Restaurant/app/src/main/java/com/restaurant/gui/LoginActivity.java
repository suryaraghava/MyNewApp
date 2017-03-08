package com.restaurant.gui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.restaurant.R;
import com.restaurant.util.Constants;
import com.restaurant.util.Utils;

public class LoginActivity extends AppCompatActivity implements View.OnTouchListener {

    private EditText nameEt;
    private Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nameEt = (EditText) findViewById(R.id.nameEt);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(MotionEvent.ACTION_DOWN == event.getAction()) {
            if(v.getId() == R.id.loginBtn) {
                String name = nameEt.getText().toString();
                if(name == null || "".equals(name)) {
                    nameEt.setError("Please enter your name.");
                    return false;
                }

                Utils.saveString(this, Constants.LOGIN_NAME_KEY,name);
                Utils.startIntent(LoginActivity.this,HomeActivity.class);
                finish();

            }
        }
        return false;
    }
}
