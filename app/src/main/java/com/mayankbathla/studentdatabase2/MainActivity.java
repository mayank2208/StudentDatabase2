package com.mayankbathla.studentdatabase2;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ListItemClickListener{



    Button addStudentBtn;
    EditText studentName;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    DatabaseHelper databaseHelper;
    DatabaseReference databaseReference;



    RecyclerAdapter recyclerAdapter;
    ArrayList<StudentModel> studentModelArrayList = new ArrayList<>();


    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_sample);

        databaseHelper = new DatabaseHelper(this);




        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerAdapter = new
                RecyclerAdapter(studentModelArrayList,
                this);

        recyclerView.setAdapter(recyclerAdapter);

        databaseReference = FirebaseDatabase.
                getInstance().getReference();

        databaseReference.
                child("Students").
                addValueEventListener
                        (new ValueEventListener() {

                            @Override
                            public void onDataChange
                                    (DataSnapshot dataSnapshot) {

                                Log.d(LOG_TAG,"Child count: " + dataSnapshot);

                                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
//                    Log.d(TAG, "Student Name is: " + snapshot.child("name").getValue());
//                    Log.d(TAG, "Student College is: " + snapshot.child("college").getValue());
//                    Log.d(TAG, "Student Address is: " + snapshot.child("address").getValue());
//                    Log.d(TAG, "Student Fees is: " + snapshot.child("fees").getValue());

                                    String studentName = String.valueOf(snapshot.child("name").getValue());
                                    String collegeName = String.valueOf(snapshot.child("college").getValue());
                                    String address = String.valueOf(snapshot.child("address").getValue());
                                    int fees = Integer.parseInt(snapshot.child("fees").getValue().toString());

                                    studentModelArrayList.add
                                            (new StudentModel(studentName));
                                }

                                recyclerAdapter.notifyDataSetChanged();
                                progressBar.setVisibility(View.GONE);
                                recyclerView.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onCancelled
                                    (DatabaseError databaseError) {

                            }
                        });

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

    @Override
    public void onListItemClickListener(int clickedItemIndex) {
        Toast.makeText(getApplicationContext(), studentModelArrayList.get(clickedItemIndex).name, Toast.LENGTH_SHORT).show();
    }
}

