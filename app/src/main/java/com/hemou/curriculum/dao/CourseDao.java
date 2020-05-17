package com.hemou.curriculum.dao;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.NonNull;

import com.hemou.curriculum.pojo.Course;

import java.util.List;

public class CourseDao {

    private CourseHelper courseHelper;

    public CourseDao(Context context) {
        courseHelper = new CourseHelper(context);
    }

    public long insert(@NonNull Course course){
        ContentValues values = new ContentValues();
        values.put("courseName", course.getCourseName());
        values.put("teacherName", course.getTeacherName());
        values.put("courseTime", course.getCourseTime());
        values.put("startWeek", course.getStartWeek());
        values.put("endWeek", course.getEndWeek());
        long count = courseHelper.insert(null, values);
        return count;
    }

    public int delete(int id){
        return courseHelper.delete("_id=?", new String[]{String.valueOf(id)});
    }

    public int update(ContentValues values, String whereClause, String[] whereArgs){
        int count = courseHelper.update(values, whereClause, whereArgs);
        return count;
    }

    public List<Course> query(){
        return courseHelper.query(null, null, null, null);
    }
}
