package com.example.donista.newproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class GrantsListAdapter extends BaseAdapter {
    private ArrayList<Grant> grantsListData;
    private LayoutInflater layoutInflater;

    public GrantsListAdapter(Context aContext, ArrayList<Grant> listData) {
        this.grantsListData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return grantsListData.size();
    }

    @Override
    public Object getItem(int position) {
        return grantsListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.one_grant_in_list_layout, null);
            holder = new ViewHolder();
            holder.grantName = (TextView) convertView.findViewById(R.id.grantName);
            holder.grantTagsEdit=(EditText) convertView.findViewById(R.id.grantTagsEdit);
            holder.grantDeadlineEdit = (TextView) convertView.findViewById(R.id.grantDeadlineEdit);
            holder.checkBox=(CheckBox)convertView.findViewById(R.id.checkBox);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.grantName.setText(grantsListData.get(position).getGrantName());
        holder.grantTagsEdit.setText(grantsListData.get(position).getTags());
        holder.grantDeadlineEdit.setText(grantsListData.get(position).getGrantDeadline());
        holder.checkBox.setText(grantsListData.get(position).getcheckBox());
        return convertView;
    }

    public void add(Grant grant) {
        grantsListData.add(grant);
        notifyDataSetChanged();
    }

    static class ViewHolder {
        TextView grantName;
        TextView grantTagsEdit;
        TextView grantDeadlineEdit;
        CheckBox checkBox;
    }
}