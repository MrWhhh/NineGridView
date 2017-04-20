package com.wh.ninegridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.wh.ninegridlib.NineGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MrWhhh .
 * @date : 2017/4/20 .
 * @description : .
 */
public class NineGridActivity extends AppCompatActivity {

    ListView listView;

    List<TalkInfo> list;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_list);
        listView = (ListView) findViewById(R.id.listview);

        initList();

        adapter = new ListAdapter(this,list, NineGridView.STYLE_GRID);
        listView.setAdapter(adapter);

    }

    public void initList() {
        List<TalkInfo.PhotoInfo> list1 = new ArrayList<>();
        List<TalkInfo.PhotoInfo> list2 = new ArrayList<>();
        List<TalkInfo.PhotoInfo> list3 = new ArrayList<>();
        List<TalkInfo.PhotoInfo> list4 = new ArrayList<>();
        List<TalkInfo.PhotoInfo> list5 = new ArrayList<>();
        List<TalkInfo.PhotoInfo> list6 = new ArrayList<>();
        List<TalkInfo.PhotoInfo> list7 = new ArrayList<>();
        List<TalkInfo.PhotoInfo> list8 = new ArrayList<>();
        List<TalkInfo.PhotoInfo> list9 = new ArrayList<>();
        list1.add(new TalkInfo.PhotoInfo(R.mipmap.aa1));
        list2.add(new TalkInfo.PhotoInfo(R.mipmap.aa1));
        list2.add(new TalkInfo.PhotoInfo(R.mipmap.aa2));
        list3.add(new TalkInfo.PhotoInfo(R.mipmap.aa1));
        list3.add(new TalkInfo.PhotoInfo(R.mipmap.aa2));
        list3.add(new TalkInfo.PhotoInfo(R.mipmap.aa3));
        list4.add(new TalkInfo.PhotoInfo(R.mipmap.aa1));
        list4.add(new TalkInfo.PhotoInfo(R.mipmap.aa2));
        list4.add(new TalkInfo.PhotoInfo(R.mipmap.aa3));
        list4.add(new TalkInfo.PhotoInfo(R.mipmap.aa4));
        list5.add(new TalkInfo.PhotoInfo(R.mipmap.aa1));
        list5.add(new TalkInfo.PhotoInfo(R.mipmap.aa2));
        list5.add(new TalkInfo.PhotoInfo(R.mipmap.aa3));
        list5.add(new TalkInfo.PhotoInfo(R.mipmap.aa4));
        list5.add(new TalkInfo.PhotoInfo(R.mipmap.aa5));
        list6.add(new TalkInfo.PhotoInfo(R.mipmap.aa1));
        list6.add(new TalkInfo.PhotoInfo(R.mipmap.aa2));
        list6.add(new TalkInfo.PhotoInfo(R.mipmap.aa3));
        list6.add(new TalkInfo.PhotoInfo(R.mipmap.aa4));
        list6.add(new TalkInfo.PhotoInfo(R.mipmap.aa5));
        list6.add(new TalkInfo.PhotoInfo(R.mipmap.aa6));
        list7.add(new TalkInfo.PhotoInfo(R.mipmap.aa1));
        list7.add(new TalkInfo.PhotoInfo(R.mipmap.aa2));
        list7.add(new TalkInfo.PhotoInfo(R.mipmap.aa3));
        list7.add(new TalkInfo.PhotoInfo(R.mipmap.aa4));
        list7.add(new TalkInfo.PhotoInfo(R.mipmap.aa5));
        list7.add(new TalkInfo.PhotoInfo(R.mipmap.aa6));
        list7.add(new TalkInfo.PhotoInfo(R.mipmap.aa7));
        list8.add(new TalkInfo.PhotoInfo(R.mipmap.aa1));
        list8.add(new TalkInfo.PhotoInfo(R.mipmap.aa2));
        list8.add(new TalkInfo.PhotoInfo(R.mipmap.aa3));
        list8.add(new TalkInfo.PhotoInfo(R.mipmap.aa4));
        list8.add(new TalkInfo.PhotoInfo(R.mipmap.aa5));
        list8.add(new TalkInfo.PhotoInfo(R.mipmap.aa6));
        list8.add(new TalkInfo.PhotoInfo(R.mipmap.aa7));
        list8.add(new TalkInfo.PhotoInfo(R.mipmap.aa8));
        list9.add(new TalkInfo.PhotoInfo(R.mipmap.aa1));
        list9.add(new TalkInfo.PhotoInfo(R.mipmap.aa2));
        list9.add(new TalkInfo.PhotoInfo(R.mipmap.aa3));
        list9.add(new TalkInfo.PhotoInfo(R.mipmap.aa4));
        list9.add(new TalkInfo.PhotoInfo(R.mipmap.aa5));
        list9.add(new TalkInfo.PhotoInfo(R.mipmap.aa6));
        list9.add(new TalkInfo.PhotoInfo(R.mipmap.aa7));
        list9.add(new TalkInfo.PhotoInfo(R.mipmap.aa8));
        list9.add(new TalkInfo.PhotoInfo(R.mipmap.aa9));
        list = new ArrayList<>();
        list.add(new TalkInfo("", "", list1));
        list.add(new TalkInfo("", "", list2));
        list.add(new TalkInfo("", "", list3));
        list.add(new TalkInfo("", "", list4));
        list.add(new TalkInfo("", "", list5));
        list.add(new TalkInfo("", "", list6));
        list.add(new TalkInfo("", "", list7));
        list.add(new TalkInfo("", "", list8));
        list.add(new TalkInfo("", "", list9));
        list.add(new TalkInfo("", "", list1));
        list.add(new TalkInfo("", "", list2));
        list.add(new TalkInfo("", "", list3));
        list.add(new TalkInfo("", "", list4));
    }
}
