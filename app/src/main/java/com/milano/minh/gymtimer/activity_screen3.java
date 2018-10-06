package com.milano.minh.gymtimer;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class activity_screen3 extends Activity {
    Button btn_muc1, btn_muc2, btn_muc3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        // nhan user tu mh1
        Bundle bd = getIntent().getExtras();
        if(bd!=null) {

        }

        btn_muc1=(Button) findViewById(R.id.btn_muc1);
        btn_muc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_muc2=(Button) findViewById(R.id.btn_muc2);
        btn_muc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_muc3= (Button) findViewById(R.id.btn_muc3);
        btn_muc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
