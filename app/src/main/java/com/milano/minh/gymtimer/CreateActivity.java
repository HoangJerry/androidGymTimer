package com.milano.minh.gymtimer;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.milano.minh.gymtimer.database.Database;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class CreateActivity extends AppCompatActivity {
    final String DATABASE_NAME = "gymdb.sqlite3";
    SQLiteDatabase database;
    EditText edt_lesson, edt_content, edt_key_youtube;
    Button btn_submit, btn_select_img, btn_chup;
    ImageView img_view_demo;
    final  int REQUEST_TAKE_PHOTO = 123;
    final  int REQUEST_CHOOSE_PHOTO = 321;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        addControls();
        addEvent();
        initUI();
    }

    private  void  addControls() {
        btn_select_img = (Button) findViewById(R.id.btn_select_img);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        edt_lesson = (EditText) findViewById(R.id.edt_lesson);
        edt_content = (EditText) findViewById(R.id.edt_content);
        edt_key_youtube = (EditText) findViewById(R.id.edt_key_youtube);
        img_view_demo = (ImageView) findViewById(R.id.img_view_demo);
        btn_chup =  (Button) findViewById(R.id.btn_chup);
    }

    private void initUI() {

    }

    private void takePicture() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_TAKE_PHOTO );
    }

    private void choosePhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");

        startActivityForResult(intent, REQUEST_CHOOSE_PHOTO );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK) {
            if ( requestCode == REQUEST_CHOOSE_PHOTO) {

                try {
                    Uri imageUri = data.getData();
                    InputStream is = getContentResolver().openInputStream(imageUri);
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    img_view_demo.setImageBitmap(bitmap);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            } else if(requestCode == REQUEST_TAKE_PHOTO){
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                img_view_demo.setImageBitmap(bitmap);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void addEvent () {
        btn_select_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePhoto();
            }
        });

        btn_chup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create();
            }
        });
    }

    private  void create () {
        String name = edt_lesson.getText().toString();
        String content = edt_content.getText().toString();
        String youtube = edt_key_youtube.getText().toString();
        byte[] picture = getByArrayFromImageView(img_view_demo);
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("content", content);
        contentValues.put("picture", picture);
        contentValues.put("youtube", youtube);
        String msg ="";
        database = Database.initDatabase(this, DATABASE_NAME);
        if(database.insert("exercise",null, contentValues) == -1) {
            msg = "Tạo không thành công!!";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        } else {
            msg = "Tạo thành công!!";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(CreateActivity.this, LevelActivity.class);
            startActivity(intent);
        }


    }

    public byte[] getByArrayFromImageView(ImageView imgv){
        BitmapDrawable drawable = (BitmapDrawable) imgv.getDrawable();
        Bitmap bmp = drawable.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
}

