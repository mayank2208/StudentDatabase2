package com.mayankbathla.studentdatabase2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    Button addStudentBtn;
    EditText studentName;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        studentName=(EditText) findViewById(R.id.edit_text);
        addStudentBtn=(Button) findViewById(R.id.addStudentButton);

        databaseHelper = new DatabaseHelper(this);

        addStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = studentName.getText().toString();

                /*
                 * Storing the new values into the arrayList using the
                 * Student class object.*/
                databaseHelper.addNewStudent(new StudentModel(name));

                /*
                 * Showing a success message once the data has been saved into arrayList*/
                Toast.makeText(getApplicationContext(), "Student data saved successfully", Toast.LENGTH_LONG).show();
            }
        });



    }

    public void lauchBackActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }
}
