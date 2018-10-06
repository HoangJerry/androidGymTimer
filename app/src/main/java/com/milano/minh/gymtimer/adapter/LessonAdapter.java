package com.milano.minh.gymtimer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.milano.minh.gymtimer.LessonActivity;
import com.milano.minh.gymtimer.R;
import com.milano.minh.gymtimer.models.Lesson;

import java.util.List;

public class LessonAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private List<Lesson> lessonList;

    public LessonAdapter(LessonActivity context, int layout, List<Lesson> lessonList) {
        this.context = context;
        this.layout = layout;
        this.lessonList = lessonList;
    }

    /**
     *
     * Tra ve so dong hien thi tren list view
     */
    @Override
    public int getCount() {
        return lessonList.size();
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
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            // khoi tao vie holder
            viewHolder = new ViewHolder();

            // anh xa view
            viewHolder.tv_lesson = (TextView) view.findViewById(R.id.tv_lesson);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }


        // gan gia tri
        Lesson lesson = lessonList.get(position);
        viewHolder.tv_lesson.setText(lesson.getLesson());

        // gan animation
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.scale_list);
        view.startAnimation(animation);
        return view;
    }

    private class ViewHolder {
        public  TextView tv_lesson;
    }
}
