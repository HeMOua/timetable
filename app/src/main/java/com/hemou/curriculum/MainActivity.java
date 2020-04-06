package com.hemou.curriculum;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hemou.curriculum.component.TimeTable;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimeTable  timeTable = findViewById(R.id.timeTable);
        timeTable.loadData(acquireData(), new Date(1582473600000L));//2020-2-24
    }

    private List<Course> acquireData() {
        List<Course> courses = null;
        SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
        // if(sp.getBoolean("isFirstUse", true)){//首次使用
            Toast.makeText(this, "首次使用程序\n初始化中...", Toast.LENGTH_SHORT).show();
            sp.edit().putBoolean("isFirstUse", false).apply();
            String json = JsonDataUtil.getJson(this, "config.json");
            JSONObject jsonObject = JSON.parseObject(json);
            Log.d("jsonText", jsonObject.toJSONString());
            courses = JSON.parseArray(jsonObject.getJSONArray("courses").toJSONString(), Course.class);
        // }else{
        //     //数据库中读取
        // }
        return courses;
    }
}
