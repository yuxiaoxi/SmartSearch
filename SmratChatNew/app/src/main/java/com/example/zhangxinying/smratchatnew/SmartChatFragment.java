package com.example.zhangxinying.smratchatnew;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxinying on 16/9/7.
 */
public class SmartChatFragment extends Fragment implements View.OnClickListener {
    private ListView mlvData;
    private RecyclerView mlvTag;
    private LinearLayoutManager mLayoutManager;
    private LinearLayout mLlsmart;
    private InputMethodManager manager = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_smart, null);
        mlvData = (ListView) view.findViewById(R.id.lv_data);
        mlvData.setAdapter(getDdataAdapter());
        mlvTag = (RecyclerView) view.findViewById(R.id.lv_tag);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mlvTag.setLayoutManager(mLayoutManager);
        mlvTag.setAdapter(getTagAdapter());
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mLlsmart = (LinearLayout)getActivity().findViewById(R.id.lv_smart);
        mLlsmart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = ( InputMethodManager )getActivity().getSystemService( Context.INPUT_METHOD_SERVICE );
                if ( imm.isActive( ) ) {
                    imm.hideSoftInputFromWindow( v.getApplicationWindowToken( ) , 0 );}

            }
        });
    }

    private BaseAdapter getDdataAdapter() {

        return new ChatAdapter(getActivity(), getMyData());
    }

    private TagAdapter getTagAdapter() {
        return new TagAdapter(getActivity(), getMtag());
    }


    private List<Message> getMyData() {

        List<Message> msgList = new ArrayList<Message>();
        Message msg;
        msg = new Message();
        msg.setType(ChatAdapter.VALUE_LEFT_TEXT);
        msg.setValue("小主人，点小评有什么可以帮您？");
        msgList.add(msg);

//        msg = new Message();
//        msg.setType(ChatAdapter.VALUE_TIME_TIP);
//        msg.setValue("2016-09-07 下午6:25");
//        msgList.add(msg);

        msg = new Message();
        msg.setType(ChatAdapter.VALUE_RIGHT_TEXT);
        msg.setValue("给我推荐一个餐厅");
        msgList.add(msg);

        msg = new Message();
        msg.setType(ChatAdapter.VALUE_LEFT_TEXT);
        msg.setValue("您需要怎样的餐厅");
        msgList.add(msg);

        msg = new Message();
        msg.setType(ChatAdapter.VALUE_RIGHT_TEXT);
        msg.setValue("看看附近有哪些");
        msgList.add(msg);

        msg = new Message();
        msg.setType(ChatAdapter.VALUE_LEFT_TEXT);
        msg.setValue("要不要挑个口味");
        msgList.add(msg);

        msg = new Message();
        msg.setType(ChatAdapter.VALUE_RIGHT_TEXT);
        msg.setValue("本帮浙江菜");
        msgList.add(msg);

        msg = new Message();
        msg.setType(ChatAdapter.VALUE_LEFT_TEXT);
        msg.setValue("要不要选个价位");
        msgList.add(msg);

        msg = new Message();
        msg.setType(ChatAdapter.VALUE_RIGHT_TEXT);
        msg.setValue("100-300之间");
        msgList.add(msg);


//        msg = new Message();
//        msg.setType(ChatAdapter.VALUE_LEFT_IMAGE);
//        msg.setValue("2");
//        msgList.add(msg);


        msg = new Message();
        msg.setType(ChatAdapter.VALUE_LEFT_TEXT);
        msg.setValue("点小评已为您推荐餐厅");
        msgList.add(msg);

        return msgList;

    }


    private List<Message> getMtag() {
        List<Message> msglist = new ArrayList<Message>();
        Message msg;
        msg = new Message();
        msg.setValue("挑餐厅");
        msglist.add(msg);


        msg = new Message();
        msg.setValue("点外卖");
        msglist.add(msg);


        msg = new Message();
        msg.setValue("吃大餐");
        msglist.add(msg);


        msg = new Message();
        msg.setValue("霸王餐");
        msglist.add(msg);

        msg = new Message();
        msg.setValue("烛光晚宴");
        msglist.add(msg);
        return msglist;
    }


    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.lv_smart:
//                InputMethodManager imm = ( InputMethodManager )v.getContext( ).getSystemService( Context.INPUT_METHOD_SERVICE );
//                if ( imm.isActive( ) ) {
//                    imm.hideSoftInputFromWindow( v.getApplicationWindowToken( ) , 0 );
//
//
//            }
//
//        }
    }
}
