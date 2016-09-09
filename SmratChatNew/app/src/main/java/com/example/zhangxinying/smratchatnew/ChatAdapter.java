package com.example.zhangxinying.smratchatnew;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends BaseAdapter {

    public static final String KEY = "key";
    public static final String VALUE = "value";

    public static final int VALUE_LEFT_TEXT = 1;
    public static final int VALUE_RIGHT_TEXT = 2;
    private LayoutInflater mInflater;
    private List<Message> myList;

    public ChatAdapter(Context context, List<Message> myList) {
        this.myList = myList;

        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int arg0) {
        return myList.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup arg2) {

        Message msg = myList.get(position);
        int type = getItemViewType(position);
        ViewHolderRightText holderRightText = null;
        ViewHolderLeftText holderLeftText = null;
        if (convertView == null) {
            switch (type) {
                // 左边
                case VALUE_LEFT_TEXT:
                    holderLeftText = new ViewHolderLeftText();
                    convertView = mInflater.inflate(R.layout.list_item_left_text,
                            null);
                    holderLeftText.ivLeftIcon = (ImageView) convertView
                            .findViewById(R.id.iv_icon);
                    holderLeftText.btnLeftText = (TextView) convertView
                            .findViewById(R.id.btn_left_text);
                    holderLeftText.btnLeftText.setText(msg.getValue());
                    convertView.setTag(holderLeftText);
                    break;

                case VALUE_RIGHT_TEXT:
                    holderRightText = new ViewHolderRightText();
                    convertView = mInflater.inflate(R.layout.list_item_right_text,
                            null);
                    holderRightText.ivRightIcon = (ImageView) convertView
                            .findViewById(R.id.iv_icon);
                    holderRightText.btnRightText = (TextView) convertView
                            .findViewById(R.id.btn_right_text);
                    holderRightText.btnRightText.setText(msg.getValue());
                    convertView.setTag(holderRightText);
                    break;

                default:
                    break;
            }

        } else {
            Log.d("baseAdapter", "Adapter_:" + (convertView == null));
            switch (type) {
                case VALUE_LEFT_TEXT:
                    holderLeftText = (ViewHolderLeftText) convertView.getTag();
                    holderLeftText.btnLeftText.setText(msg.getValue());
                    break;
                case VALUE_RIGHT_TEXT:
                    holderRightText = (ViewHolderRightText) convertView.getTag();
                    holderRightText.btnRightText.setText(msg.getValue());
                    break;
                default:
                    break;
            }

            //holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }


    @Override
    public int getItemViewType(int position) {

        Message msg = myList.get(position);
        int type = msg.getType();
        Log.e("TYPE:", "" + type);
        return type;
    }

    @Override
    public int getViewTypeCount() {
        return 5;
    }

    class ViewHolderRightText {
        private ImageView ivRightIcon;
        private TextView btnRightText;
    }

    class ViewHolderLeftText {
        private ImageView ivLeftIcon;
        private TextView btnLeftText;
    }


}
