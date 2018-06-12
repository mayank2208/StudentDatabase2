package com.mayankbathla.studentdatabase2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class display_student extends AppCompatActivity {

    ArrayList<StudentModel> studentArrayList = new ArrayList<>();

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "student_db";

    private static final String TABLE_NAME = "student_record";
    private static final String STUDENT_NAME = "student_name";
    private static final String STUDENT_ID = "student_id";

    Button displayStudentBtn;
    DatabaseHelper databaseHelper;
    ListView list_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_student);


        displayStudentBtn=(Button) findViewById(R.id.btn_display);
        list_display=(ListView) findViewById(R.id.list_view);






        displayStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                 * Using a for loop to iterate through the list of
                 * objects that are stored in the arrayList.*/

            }
        });


    }


}
