package com.milano.minh.gymtimer;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.milano.minh.gymtimer.database.DBManager;
import com.milano.minh.gymtimer.models.User;

public class BeginActivity extends Activity {
    private EditText edit_username;
    private EditText edit_gender;
    private EditText edit_weight;
    private EditText edit_age;
    private Button btn_begin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
        final DBManager dbManager = new DBManager(this);
        edit_username = (EditText) findViewById(R.id.txt_username);
        edit_gender = (EditText) findViewById(R.id.txt_gender);
        edit_weight = (EditText) findViewById(R.id.txt_weight);
        edit_age = (EditText) findViewById(R.id.txt_age);
        btn_begin = (Button) findViewById(R.id.btn_begin);

        /**
         * TODO: Cilck tao user moi
         */
        btn_begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                User user = createUser();
//                if(user != null){
//                    dbManager.addUser(user);
//                }
                Intent intent = new Intent(BeginActivity.this, LessonActivity.class);
                startActivity(intent);
            }
        });


    }

    private User createUser(){
        String username = edit_username.getText()+"";
        String gender = edit_gender.getText()+"";
        float weight = Float.parseFloat(String.valueOf(edit_weight.getText()));
        int age = Integer.parseInt(String.valueOf(edit_age.getText()));

        User user = new User(username, gender, weight, age);

        return  user;
    }


}
