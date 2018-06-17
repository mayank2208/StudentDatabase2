package com.mayankbathla.studentdatabase2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "student_db";

    /*
     * Student_Record table details*/
    private static final String TABLE_NAME = "student_record";
    private static final String STUDENT_NAME = "student_name";
    private static final String STUDENT_ID = "student_id";


    private static final String CREATE_TABLE = "CREATE TABLE "
            + TABLE_NAME + " ( " +
            STUDENT_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + STUDENT_NAME + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);

    }


    public long addNewStudent(StudentModel studentModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(STUDENT_NAME, studentModel.name);
        long id = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        sqLiteDatabase.close();

        return id;
    }


    public List<StudentModel> allStudentsDetails() {
        List<StudentModel> studentsList = new ArrayList<>();

        String selectQuery = " SELECT * FROM " + TABLE_NAME ;

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                StudentModel studentModel = new StudentModel();
                studentModel.setId(cursor.getInt(cursor.getColumnIndex(STUDENT_ID)));
                studentModel.setName(cursor.getString(cursor.getColumnIndex(STUDENT_NAME)));

                studentsList.add(studentModel);
            } while (cursor.moveToNext());
        }

        sqLiteDatabase.close();

        return  studentsList;
    }


}
