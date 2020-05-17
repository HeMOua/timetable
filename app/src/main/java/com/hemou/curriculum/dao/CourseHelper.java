package com.hemou.curriculum.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hemou.curriculum.pojo.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseHelper extends SQLiteOpenHelper {

    public CourseHelper(Context context){
        super(context, "timetable.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table t_course(" +
                "_id integer primary key autoincrement," +
                "courseName varchar(50)," +
                "teacherName varchar(50)," +
                "classroom varchar(50), " +
                "weekType varchar(50), " +
                "day integer," +
                "section integer," +
                "startWeek integer," +
                "endWeek integer," +
                "courseTime varchar(255)" +
                ")";
        db.execSQL(sql);
    }

    public long insert(String nullColumnHack, ContentValues values){
        SQLiteDatabase database = getWritableDatabase();
        long count = database.insert("t_course", nullColumnHack, values);
        database.close();
        return count;
    }

    public int delete(String whereClause, String[] whereArgs){
        SQLiteDatabase database = getWritableDatabase();
        int count = database.delete("t_course", whereClause, whereArgs);
        database.close();
        return count;
    }

    public int update(ContentValues values, String whereClause, String[] whereArgs){
        SQLiteDatabase database = getWritableDatabase();
        int count = database.update("t_course", values, whereClause, whereArgs);
        database.close();
        return count;
    }

    public List<Course> query(String[] columns, String selection,
                              String[] selectionArgs,
                              String orderBy){
        List<Course> list = new ArrayList<>();
        SQLiteDatabase database = getWritableDatabase();
        Cursor data = database.query("t_course", columns, selection, selectionArgs, null, null, orderBy);
        if(data.getCount() > 0){
            while(data.moveToNext()) {
                Course course = new Course();
                course.setId(data.getInt(0));
                course.setCourseName(data.getString(1));
                course.setTeacherName(data.getString(2));
                course.setClassroom(data.getString(3));
                course.setWeekType(data.getString(4));
                course.setDay(data.getInt(5));
                course.setSection(data.getInt(6));
                course.setStartWeek(data.getInt(7));
                course.setEndWeek(data.getInt(8));
                course.setCourseTime(data.getString(9));
                list.add(course);
            }
        }
        database.close();
        return list;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
