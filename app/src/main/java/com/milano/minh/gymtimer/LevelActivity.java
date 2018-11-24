package com.milano.minh.gymtimer;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class LevelActivity extends AppCompatActivity {
    Button btn_muc1, btn_muc2, btn_VN, btn_US;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        btn_muc1=(Button) findViewById(R.id.btn_muc1);
        btn_muc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, LessonActivity.class);
                startActivity(intent);
            }
        });
        btn_muc2=(Button) findViewById(R.id.btn_muc2);
        btn_muc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, LessonActivity.class);
                startActivity(intent);
            }
        });
        btn_VN=(Button) findViewById(R.id.btn_VN);
        btn_VN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLanguage("vi");
            }
        });
        btn_US= (Button) findViewById(R.id.btn_US);
        btn_US.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLanguage("en");
            }
        });
    }

    private void setLanguage(String language) {
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.locale= locale;
        getBaseContext().getResources().updateConfiguration(
                config,
                getBaseContext().getResources().getDisplayMetrics() );
        Intent intent = new Intent(LevelActivity.this, LevelActivity.class);
        startActivity(intent);

    }
}
