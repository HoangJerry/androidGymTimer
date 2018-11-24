package com.milano.minh.gymtimer.models;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.milano.minh.gymtimer.LessonActivity;
import com.milano.minh.gymtimer.MainActivity;
import com.milano.minh.gymtimer.R;
import com.milano.minh.gymtimer.YoutubeActivity;
import com.milano.minh.gymtimer.database.Database;

public class ExerciseDetailActivity extends AppCompatActivity {
    final String DATABASE_NAME = "gymdb.sqlite3";
    Button btnDemo;
    ImageView img_detail;
    TextView tv_Exe;
    String youtube;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);
        addControls();
        initUI();
        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExerciseDetailActivity.this, YoutubeActivity.class);
                intent.putExtra("YOUTUBE", youtube);
                startActivity(intent);
            }
        });
    }

    private  void initUI() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", -1);
        SQLiteDatabase database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM exercise WHERE id=?", new String[]{id + ""});
        cursor.moveToFirst();
        String content = cursor.getString(2);
        byte [] img = cursor.getBlob(3);
        Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
        img_detail.setImageBitmap(bitmap);
        tv_Exe.setText(content);
        youtube = cursor.getString(4);
    }
    private  void  addControls() {
        btnDemo = (Button) findViewById(R.id.btn_Demo);
        img_detail = (ImageView) findViewById(R.id.img_Detail);
        tv_Exe = (TextView) findViewById(R.id.tv_Exe);

    }
}
