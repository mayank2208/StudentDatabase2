package com.mayankbathla.studentdatabase2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class
display_student extends AppCompatActivity implements RecyclerAdapter.ListItemClickListener {

    ArrayList<StudentModel> studentModelArrayList = new ArrayList<>();

    Button displayStudentBtn;
    DatabaseHelper databaseHelper;
    ListView list_display;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

  //  ArrayList<StudentModel> studentModelArrayList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_student);


        displayStudentBtn=(Button) findViewById(R.id.btn_display);
        //list_display=(ListView) findViewById(R.id.list_view);

        databaseHelper = new DatabaseHelper(this);

        ArrayList<StudentModel> list = new ArrayList<>();

        list.addAll(databaseHelper.allStudentsDetails());

        recyclerView = findViewById(R.id.list_view);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerAdapter = new
                RecyclerAdapter(list, this);

        recyclerView.setAdapter(recyclerAdapter);





    }


    @Override
    public void onListItemClickListener(int clickedItemIndex) {
        Toast.makeText(getApplicationContext(), studentModelArrayList.get(clickedItemIndex).name, Toast.LENGTH_SHORT).show();

    }
}
