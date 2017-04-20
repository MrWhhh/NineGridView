package com.wh.ninegridview;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wh.ninegridlib.NineGridView;
import com.wh.ninegridlib.NineGridViewAdapter;

import java.util.List;

/**
 * @author MrWhhh .
 * @date : 2017/4/20 .
 * @description : .
 */
public class ListAdapter extends BaseAdapter {

    Context context;

    List<TalkInfo> list;

    int showStyle;

    public ListAdapter(Context context, List<TalkInfo> list,int showStyle) {
        this.context = context;
        this.list = list;
        this.showStyle = showStyle;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return list != null ? list.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout, null);
            holder.nineGridView = (NineGridView) convertView.findViewById(R.id.item_nine_grid);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.nineGridView.setShowStyle(showStyle);
        holder.nineGridView.setAdapter(new NineGridViewAdapter<TalkInfo.PhotoInfo>() {
            @Override
            public void loadingWayImg(Context context, ImageView imageView, TalkInfo.PhotoInfo data) {
                imageView.setImageDrawable(ContextCompat.getDrawable(context, data.ids));
            }

            @Override
            public void onItemClick(Context context, ImageView imageView, int position, List<TalkInfo.PhotoInfo> list) {
                Toast.makeText(context, "点击图第" + position + "图片", Toast.LENGTH_LONG).show();
            }
        });
        holder.nineGridView.setData(list.get(position).photo);
        return convertView;
    }

    class ViewHolder {
        ImageView head;
        TextView name;
        TextView content;
        NineGridView nineGridView;
    }
}
