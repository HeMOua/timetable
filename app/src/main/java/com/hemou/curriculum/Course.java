package com.hemou.curriculum;

public class Course implements Cloneable {
    private int id;
    private String courseName;//课程名
    private String teacherName;//教师名
    private String classroom;//教室
    private String weekType;//单双周类型
    private int day;//星期几
    private int section;//节次
    private int startWeek;//开始周次
    private int endWeek;//结束周次

    /**
     * 格式：星期-节次-单双周-房号
     */
    private String courseTime;//上课时间

    public Course() {
    }

    public Course(String courseName, String teacherName , int startWeek, int endWeek, String courseTime) {
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.courseTime = courseTime;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
    }

    public String getWeekType() {
        return weekType;
    }

    public void setWeekType(String weekType) {
        this.weekType = weekType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public int getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }

    public int getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(int endWeek) {
        this.endWeek = endWeek;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }


    public Course clone()  {
        try {
            return (Course) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", classroom='" + classroom + '\'' +
                ", weekType='" + weekType + '\'' +
                ", day=" + day +
                ", section=" + section +
                ", startWeek=" + startWeek +
                ", endWeek=" + endWeek +
                ", courseTime='" + courseTime + '\'' +
                '}';
    }
}
