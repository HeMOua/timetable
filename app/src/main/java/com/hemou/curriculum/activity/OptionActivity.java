package com.hemou.curriculum.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hemou.curriculum.R;
import com.hemou.curriculum.dao.CourseDao;
import com.hemou.curriculum.pojo.Course;

import java.util.List;

public class OptionActivity extends AppCompatActivity {

    private ListView lvContent;
    private CourseDao courseDao = new CourseDao(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        lvContent = findViewById(R.id.lvContent);

        show();
    }

    /**
     * 所有课程
     */
    private void show(){
        List<Course> list = courseDao.query();
        int listSize = list.size();
        if(listSize > 0) {
            String[] courseNames = new String[listSize];
            for (int i = 0; i < listSize; i++) courseNames[i] = list.get(i).getCourseName();
            ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseNames);
            lvContent.setAdapter(arrayAdapter);
        }else{
            Toast.makeText(this, "暂无数据，请添加课程！", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 返回
     * @param view
     */
    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * 添加课程
     * @param view
     */
    public void addCourse(View view) {
        Intent intent = new Intent(this, AddCourseActivity.class);
        startActivity(intent);
    }
}
