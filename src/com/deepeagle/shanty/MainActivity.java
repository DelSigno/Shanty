package com.deepeagle.shanty;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import com.deepeagle.shanty.R;

import com.deepeagle.shanty.trustgraph.Node;
import com.deepeagle.shanty.utils.shantyRand;
import com.deepeagle.shanty.views.NodeView;
import com.deepeagle.shanty.views.NodeViewAdapter;


public class MainActivity extends Activity {

    private final static String TAG = "MainActivity";
    static int TESTNODES = 10;

    
    //*
    //*       Important variables
    //*
    private ArrayList<Node> nodeList = new ArrayList<Node>();


    @Override
    protected void onCreate(Bundle savedInstanceState){

        //**********************************************************
        //Basic constructor shit
        // *********************************************************
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //**********************************************************
        //Creation of the lame test nodes
        // *********************************************************

        
        KeyPairGenerator keyGen;
        KeyPair decryptionPair;
        KeyPair encryptionPair;

        String[] thePMs = {"one", "two", "three", "four", "five"};
        try {
            keyGen = KeyPairGenerator.getInstance("RSA");

        }catch(NoSuchAlgorithmException e){
            int fucked = 1;
            return;
        }







        //**********************************************************
        //Creation of the lame test nodes
        // *********************************************************

        //Keysize will normally be 2048, 1024 for quicker compiling at early stages
        keyGen.initialize(2048);

        
    	Log.d(TAG, "Generating keys");
        for(Integer i = 0; i < TESTNODES; i++){
            decryptionPair = keyGen.generateKeyPair();
            encryptionPair = keyGen.generateKeyPair();  	
        	Node paul = new Node(decryptionPair.getPublic(),encryptionPair.getPublic(),shantyRand.getRandomString(128), thePMs, i.toString());
            nodeList.add(paul);
        }
        
        

        
        Log.d(TAG, "Adding new view to centerNodes");
        NodeViewAdapter nodeViewAdapter = new NodeViewAdapter(this,nodeList);
        
        ListView centerNodes = (ListView)findViewById(R.id.nodeListView);
        centerNodes.setAdapter(nodeViewAdapter);
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
