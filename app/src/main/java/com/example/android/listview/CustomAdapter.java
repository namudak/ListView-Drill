package com.example.android.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by student on 2015-08-31.
 */
public class CustomAdapter extends BaseAdapter {
    private final Context mContext;
    private List<People> mData;


    public CustomAdapter(Context context, List<People> mData) {
        mContext= context;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Item's layout
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        // Layout conpose
        // convertView first loaded
        if(convertView== null){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.item_people, parent, false);
            ImageView image= (ImageView)convertView.findViewById(R.id.logo);
            TextView name= (TextView)convertView.findViewById(R.id.text1);
            TextView phone= (TextView)convertView.findViewById(R.id.text2);

            viewHolder= new ViewHolder();
            viewHolder.image= image;
            viewHolder.name= name;
            viewHolder.phone=phone;

            convertView.setTag(viewHolder);

        } else {// reuse convertView
            viewHolder= (ViewHolder)convertView.getTag();
        }

        // Bind data to Layout
        People people= (People)getItem(position);
        viewHolder.image.setImageResource(people.getImageResourceId());
        viewHolder.name.setText(people.getName());
        viewHolder.phone.setText(people.getPhoneNumber());

        // Return view
        return convertView;
    }
    // Inner class by static
    static class ViewHolder {
        ImageView image;
        TextView name;
        TextView phone;
    }
}
