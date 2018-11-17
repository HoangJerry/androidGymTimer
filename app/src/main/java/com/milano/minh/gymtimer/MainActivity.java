package com.milano.minh.gymtimer;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.milano.minh.gymtimer.database.Database;

public class MainActivity extends AppCompatActivity {
    final String DATABASE_NAME = "gymdb.sqlite3";
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM exercise", null);
        cursor.moveToFirst();
        Toast.makeText(this, cursor.getString(1), Toast.LENGTH_LONG).show();
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, LessonActivity.class);
                        startActivity(intent);
                    }
                },
                5000);

    }
}
