package com.example.donista.newproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GrantsListAdapter extends BaseAdapter {
    private ArrayList<Grant> grantListView;
    private LayoutInflater layoutInflater;


    public GrantsListAdapter(Context aContext) {
        this.grantListView = new ArrayList<>();
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return grantListView.size();
    }

    @Override
    public Object getItem(int position) {
        return grantListView.get(position);
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
            holder.grantTitle = (TextView) convertView.findViewById(R.id.grantName);
            holder.grantTags=(TextView) convertView.findViewById(R.id.grantTagsEdit);
            holder.grantDeadlineEdit = (TextView) convertView.findViewById(R.id.grantDeadlineEdit);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.grantTitle.setText(grantListView.get(position).getGrantName());
        holder.grantTags.setText(grantListView.get(position).getGrantTagsEdit());
        holder.grantDeadlineEdit.setText(grantListView.get(position).getGrantDeadlineEdit());
        return convertView;
    }

    public void add(Grant grant) {
        grantListView.add(grant);
        notifyDataSetChanged();
    }

    static class ViewHolder {
        TextView grantTitle;
        TextView grantTags;
        TextView grantDeadlineEdit;

    }
}