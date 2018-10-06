package com.milano.minh.gymtimer.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.milano.minh.gymtimer.models.User;

public class DBManager extends SQLiteOpenHelper {
    private final String TAG = "DBManager";
    private static  final String DATABASE_NAME = "gym_timer";
    private static  final String TABLE_USER = "user";
        private static  final String ID = "id";
        private static  final String USERNAME = "username";
        private static  final String GENDER = "gender";
        private static  final String WEIGHT = "weight";
        private static  final String AGE = "age";
        private static  final int VERSION = 1;
    private Context context;

    private String SQLQuery= "CREATE TABLE "+TABLE_USER+
            " ("+ID+" integer primary key, "+
            USERNAME+" TEXT, "+
            GENDER+" TEXT, "+
            WEIGHT+ " TEXT, "+
            AGE+" TEXT)";

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context= context;
        Log.d(TAG, "DNManager: ");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLQuery);
        Log.d(TAG, "onCreate: ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade: ");
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME, user.getUserName());
        values.put(GENDER, user.getGender());
        values.put(AGE, user.getAge());
        values.put(WEIGHT, user.getWeight());

        db.insert(TABLE_USER, null, values);

        db.close();
        Log.d(TAG, "addUSer success: ");
    }

    // Check isEmpty user
    public User getUser() {
       String selectQuery = "SELECT * FROM "+ TABLE_USER;
       SQLiteDatabase db = this.getWritableDatabase();
        User user = new User();
       // lay du lieu tra ve (chua du lieu tra ve)
       Cursor cursor= db.rawQuery(selectQuery, null);
       if(cursor.moveToFirst()){
        user.setuID(cursor.getInt(0));
        user.setUserName(cursor.getString(1));
        user.setGender(cursor.getString(2));
        user.setWeight(cursor.getFloat(3));
        user.setAge(cursor.getInt(4));
       }
       db.close();
       Log.d(TAG, user.getUserName());
       return user;

    }
}
