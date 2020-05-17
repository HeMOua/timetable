package com.hemou.curriculum.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.hemou.curriculum.R;

public class AddCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
    }

    public void back(View view) {
        Intent intent = new Intent(this, OptionActivity.class);
        startActivity(intent);
    }

    public void addLesson(View view){
        View inflate = getLayoutInflater().inflate(R.layout.lession_item, null);
        new AlertDialog.Builder(this)
                .setView(inflate)
                .setPositiveButton("添加", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();
    }

    public void delCourse(View view) {
    }
}
