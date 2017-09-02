package com.example.yukai.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by yukai on 2017/8/27.
 */

public class MyAdapter extends BaseAdapter{

    private Context mContext;

    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.item_id);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        refreshView(viewHolder, position);
        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return position + "";
    }

    public void setContext(Context context){
        mContext = context;
    }

    private void refreshView(ViewHolder viewHolder, int position){
        viewHolder.textView.setText(position + "");
    }

    private class ViewHolder{
        TextView textView;
    }
}
