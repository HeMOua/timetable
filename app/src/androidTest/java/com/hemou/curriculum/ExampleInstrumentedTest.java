package com.hemou.curriculum;

import android.content.Context;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.hemou.curriculum", appContext.getPackageName());
    }

    public void testParseJson(){
        String json = JsonDataUtil.getJson(new MainActivity(), "config.json");
        Log.d("parseJson", json);
    }

    public void testJson() throws JSONException {
        JSONObject jsonObject = new JSONObject();

        List<Course> courseList = new ArrayList<>();
        courseList.add((new Course("形式与政策", "肖惠朝", 1, 7, "3:5:s:XC-D")));
        courseList.add((new Course("计算机信息安全", "李照明", 1, 11, "3:5:d:XC207;5:3:n:XC205")));
        courseList.add((new Course("软件工程", "彭惠玲", 1, 12, "2:3:n:XC412;5:1:n:XC308")));
        courseList.add((new Course("Web前端开发", "罗豪凡", 1, 12, "1:5:n:XC412;3:1:n:XC412")));
        courseList.add((new Course("JavaWeb高级编程", "刁文广", 5, 16, "1:3:n:XC412;3:7:n:XC412")));
        courseList.add((new Course("Android应用开发", "卢向华", 5, 16, "4:3:n:XD110;5:5:n:XC310")));
        courseList.add((new Course("计算机视觉应用", "王国强", 1, 8, "2:5:n:XC305;4:1:n:XC409")));
        courseList.add((new Course("计算机新技术", "李淳凡", 6, 9, "1:1:n:XC4;1:7:n:XC4;2:1:n:XC4;3:3:n:XC4")));

        JSONArray courses = JSON.parseArray(JSON.toJSONString(courseList));

        jsonObject.put("courses", courses);

        Context context = new MainActivity();
        // context.openFileInput()

        List<Course> cs = JSON.parseArray(jsonObject.getJSONArray("courses").toJSONString(), Course.class);
        System.out.println(cs.toString());
    }
}
