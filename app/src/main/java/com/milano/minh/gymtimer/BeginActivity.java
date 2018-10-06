package com.milano.minh.gymtimer;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class BeginActivity extends Activity {
    Button btn_begin;
    String user= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
        btn_begin = (Button)findViewById(R.id.btn_begin);

        btn_begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mh2= new Intent(BeginActivity.this, activity_screen3.class);
                user=findViewById(R.id.txt_username).toString();
                mh2.putExtra("user",user );
                startActivity(mh2);
            }
        });



    }

}
