package com.mayankbathla.studentdatabase2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DisplayActivity2 extends AppCompatActivity {

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display2);
    }

    public void lauchDisplayActivity2(View view) {

        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this , display_student.class);
        startActivity(intent);
    }




}

