package com.example.zhangxinying.smratchatnew;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhangxinying on 16/9/8.
 */
public class TagAdapter extends RecyclerView.Adapter<TagAdapter.MyViewHolder> {
    private List<Message> mylist;
    private Context mContex;


    public TagAdapter(Context context, List<Message> msglist) {
        this.mContex = context;
        this.mylist = msglist;
    }

    @Override
    public TagAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(mContex).inflate(R
                .layout.tag_item, null, false));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvTag.setText(mylist.get(position).getValue());
        String a = mylist.get(position).getValue();
        System.out.println(a);
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTag;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvTag = (TextView) itemView.findViewById(R.id.item_tvtag);
        }
    }

}

