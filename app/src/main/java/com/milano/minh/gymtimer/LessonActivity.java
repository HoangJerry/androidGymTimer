package com.milano.minh.gymtimer;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.milano.minh.gymtimer.adapter.ExerciseAdapter;
import com.milano.minh.gymtimer.adapter.LessonAdapter;
import com.milano.minh.gymtimer.database.Database;
import com.milano.minh.gymtimer.models.Execise;
import com.milano.minh.gymtimer.models.Lesson;

import java.util.ArrayList;

public class LessonActivity extends AppCompatActivity {
    final String DATABASE_NAME = "gymdb.sqlite3";
    SQLiteDatabase database;
    ListView listView;
    ArrayList<Execise> list;
    ExerciseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        addControls();
        readData();
    }

    private void addControls() {
        listView = (ListView) findViewById(R.id.lvLesson);
        list = new ArrayList<>();
        adapter = new ExerciseAdapter(this, list);
        listView.setAdapter(adapter);
    }
    private void readData () {
        database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM exercise", null);
        list.clear();
        for (int i = 0; i < cursor.getCount(); i++){
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String content = cursor.getString(2);
            byte [] picture = cursor.getBlob(3);
            list.add(new Execise(id, name, content, picture));
        }
        adapter.notifyDataSetChanged();
    }
}
