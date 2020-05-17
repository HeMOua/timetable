package com.hemou.curriculum.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.hemou.curriculum.R;
import com.hemou.curriculum.dao.CourseDao;
import com.hemou.curriculum.pojo.Course;
import com.hemou.curriculum.view.TimeTableView;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CourseDao courseDao = new CourseDao(this);
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("config", MODE_PRIVATE);
        TimeTableView timeTable = findViewById(R.id.timeTable);

        //获取开学时间
        long date = sp.getLong("date", 1582473600000L);
        timeTable.loadData(acquireData(), new Date(date));//2020-2-24
    }

    private List<Course> acquireData() {
        List<Course> courses = null;
        sp = getSharedPreferences("config", MODE_PRIVATE);
        if (!sp.getBoolean("isFirstUse", true)) {//首次使用
            courses = courseDao.query();
        }
        return courses;
    }

    /**
     * 菜单
     * @param view
     */
    public void category(View view) {
        Intent intent = new Intent(this, OptionActivity.class);
        startActivity(intent);
    }
}
