package com.deepeagle.shanty.views;

import java.util.ArrayList;
import java.util.List;

import com.deepeagle.shanty.trustgraph.Node;

import com.deepeagle.shanty.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NodeViewAdapter extends ArrayAdapter<Node>{
	
	private final Context context;
	private final ArrayList<Node> nodeList;

	public NodeViewAdapter(Context context, ArrayList<Node> objects) {
		super(context, R.layout.node_view, objects);
		
		this.context = context;
		this.nodeList = objects;

	}


	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		// 1. Create inflater 
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View nodeView = inflater.inflate(R.layout.node_view, parent, false);

        // 3. Get the two text view from the rowView
        TextView userIDView = (TextView) nodeView.findViewById(R.id.userID);
        TextView announcementView = (TextView) nodeView.findViewById(R.id.announcement);
        

        // 4. Set the text for textView 
        userIDView.setText(nodeList.get(position).getUserIDTagged());
        announcementView.setText(nodeList.get(position).getAnnouncement());

        // 5. return rowView
        return nodeView;
	}
	
	
}
















