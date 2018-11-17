package com.milano.minh.gymtimer.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.milano.minh.gymtimer.R;
import com.milano.minh.gymtimer.models.Execise;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ExerciseAdapter extends BaseAdapter {
    Context context;
    ArrayList<Execise> list;

    public ExerciseAdapter(Context context, ArrayList<Execise> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.item_gym_lesson, null);
        TextView tv_lesson = (TextView) row.findViewById(R.id.tv_lesson);
        ImageView imgExercise = (ImageView) row.findViewById(R.id.iv_lesson);
        Execise execise = list.get(position);
        tv_lesson.setText(execise.getName() + "");
        Bitmap bmExecise = BitmapFactory.decodeByteArray(execise.getPicture(), 0, execise.getPicture().length);
        imgExercise.setImageBitmap(bmExecise);
        return row;
    }
}
