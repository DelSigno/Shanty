package com.deepeagle.shanty.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.deepeagle.shanty.trustgraph.Node;


/**
 * Created by Booty on 10/12/14.
 */
public class NodeView extends ListView{

    public NodeView(Context context, Node node){
        super(context);

        TextView userIDView = new TextView(context);
        userIDView.setEnabled(true);
        userIDView.setText(node.getUserID());
        userIDView.setTextAppearance(context,android.R.style.TextAppearance_Large);

        this.addFooterView(userIDView);



        Log.d("NodeView", "UserID: " + userIDView.getText());

    }


}
