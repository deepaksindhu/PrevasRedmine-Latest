/**
 *  Author: Deepak Sindhu deepak.sindhu@prevas.com
 *  
 *  Copyright 2012 by Prevas AB, www.prevas.se 
 *  This file is distributed under the GPL v3.0 license
 */

package com.prevas.redmine;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.taskadapter.redmineapi.bean.IssuePriority;

public class IssuePriorityAdapter extends ArrayAdapter<IssuePriority> 
{
	private Context mContext;
	List<IssuePriority> mPriorityList;
	
	public IssuePriorityAdapter(Context context, int textViewResourceId, List<IssuePriority> priorityList) 
	{
		super(context, textViewResourceId, priorityList);
		this.mContext = context;
		this.mPriorityList = priorityList;
	}
	
	@Override
    public View getView(int position, View convertView, ViewGroup parent) 
	{        
        TextView label = new TextView(mContext);
        label.setTextColor(Color.BLACK);
        label.setText(mPriorityList.get(position).getName());
        return label;
    }

	@Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) 
	{
        TextView label = new TextView(mContext);
        label.setTextColor(Color.BLACK);
        label.setText(mPriorityList.get(position).getName());
        return label;
    }

	@Override
	public int getCount()
	{
		return mPriorityList.size();
	}
	
	@Override
	public IssuePriority getItem(int position)
	{
		return mPriorityList.get(position);
	}
	
	@Override
	public long getItemId(int position)
	{
		return position;
	}
	
	public int getItemIndexByName(String name)
	{
		int resultIndex = 0;
		int itemCount = getCount();
		for (int i = 0; i < itemCount; ++i) {
			if (name.equals(mPriorityList.get(i).getName())) {
				resultIndex = i;
				break;
			}
		}
		return resultIndex;
	}
}
