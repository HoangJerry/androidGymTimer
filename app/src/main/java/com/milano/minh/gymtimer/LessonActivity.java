package com.milano.minh.gymtimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.milano.minh.gymtimer.adapter.LessonAdapter;
import com.milano.minh.gymtimer.models.Lesson;

import java.util.ArrayList;

public class LessonActivity extends AppCompatActivity {
    ListView lvLesson;
    ArrayList<Lesson> arrayLesson;
    LessonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        anhXa();

        adapter = new LessonAdapter(this, R.layout.item_gym_lesson, arrayLesson);
        lvLesson.setAdapter(adapter);
    }
    private void  anhXa() {
        lvLesson = (ListView) findViewById(R.id.lvLesson);
        arrayLesson = new ArrayList<>();

        // fake data
        arrayLesson.add(new Lesson("Chest", R.drawable.chest));
        arrayLesson.add(new Lesson("Arm", R.drawable.arm));
        arrayLesson.add(new Lesson("Shoulder And Back", R.drawable.shoulder_and_back));
        arrayLesson.add(new Lesson("Shoulder And Back", R.drawable.shoulder_and_back));
        arrayLesson.add(new Lesson("Shoulder And Back", R.drawable.shoulder_and_back));
        arrayLesson.add(new Lesson("Chest", R.drawable.chest));
        arrayLesson.add(new Lesson("Arm", R.drawable.arm));
        arrayLesson.add(new Lesson("Shoulder And Back", R.drawable.shoulder_and_back));
        arrayLesson.add(new Lesson("Shoulder And Back", R.drawable.shoulder_and_back));
        arrayLesson.add(new Lesson("Shoulder And Back", R.drawable.shoulder_and_back));
        arrayLesson.add(new Lesson("Chest", R.drawable.chest));
        arrayLesson.add(new Lesson("Arm", R.drawable.arm));
        arrayLesson.add(new Lesson("Shoulder And Back", R.drawable.shoulder_and_back));
        arrayLesson.add(new Lesson("Shoulder And Back", R.drawable.shoulder_and_back));
        arrayLesson.add(new Lesson("Shoulder And Back", R.drawable.shoulder_and_back));
        arrayLesson.add(new Lesson("Chest", R.drawable.chest));
        arrayLesson.add(new Lesson("Arm", R.drawable.arm));
        arrayLesson.add(new Lesson("Shoulder And Back", R.drawable.shoulder_and_back));
        arrayLesson.add(new Lesson("Shoulder And Back", R.drawable.shoulder_and_back));
        arrayLesson.add(new Lesson("Shoulder And Back", R.drawable.shoulder_and_back));
    }
}
