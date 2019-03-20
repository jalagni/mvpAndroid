package com.learning.appCore;


import com.learning.appSupport.NavMngr;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        NavMngr.getInstance().registerActivity(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
