package com.mayankbathla.studentdatabase2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button addStudentBtn;
    EditText studentName;


    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        databaseHelper = new DatabaseHelper(this);













    }

    public void lauchDisplayActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this , display_student.class);
        startActivity(intent);
    }


    public void lauchAddActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this , AddStudent.class);
        startActivity(intent);
    }
}

