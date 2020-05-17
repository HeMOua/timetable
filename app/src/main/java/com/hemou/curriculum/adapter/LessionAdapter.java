package com.hemou.curriculum.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;

import com.hemou.curriculum.R;
import com.hemou.curriculum.pojo.Course;

import java.util.List;

public class LessionAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<Course> courseList;

    public LessionAdapter(Context context, @NonNull List<Course> courseList){
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return courseList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(null == convertView){
            convertView = layoutInflater.inflate(R.layout.lession_item, null);
            holder = new ViewHolder();
            holder.etDay = convertView.findViewById(R.id.etDay);
            holder.etSection = convertView.findViewById(R.id.etSection);
            holder.rgWeekType = convertView.findViewById(R.id.rgWeekType);
            holder.etClassroom = convertView.findViewById(R.id.etClassroom);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        setContent(position, holder);
        return convertView;
    }

    private void setContent(int i, ViewHolder view){
        view.etDay.setText(courseList.get(i).getDay());
        view.etSection.setText(courseList.get(i).getSection());
        String weekType = courseList.get(i).getWeekType();
        if("s".equals(weekType)){
            view.rgWeekType.check(R.id.rbSingleWeek);
        }else if("d".equals(weekType)){
            view.rgWeekType.check(R.id.rbDoubleWeek);
        }else{
            view.rgWeekType.check(R.id.rbNormalWeek);
        }
        view.etClassroom.setText(courseList.get(i).getClassroom());
    }

    static class ViewHolder{
        EditText etDay;
        EditText etSection;
        RadioGroup rgWeekType;
        EditText etClassroom;
    }
}
