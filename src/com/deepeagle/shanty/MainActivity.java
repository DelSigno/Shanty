package com.deepeagle.shanty;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import com.deepeagle.shanty.R;

import com.deepeagle.shanty.trustgraph.Node;
import com.deepeagle.shanty.views.NodeView;


public class MainActivity extends Activity {

    private final static String TAG = "MainActivity";


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

        KeyPair decryptionPair;
        KeyPair encryptionPair;

        String[] thePMs = {"one", "two", "three", "four", "five"};
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);

            Log.d(TAG, "Generating keys");
            decryptionPair = keyGen.generateKeyPair();
            encryptionPair = keyGen.generateKeyPair();

        }catch(NoSuchAlgorithmException e){
            int fucked = 1;
            return;
        }



        Node paul = new Node(decryptionPair.getPublic(),encryptionPair.getPublic(),"Hello World", thePMs);



        //**********************************************************
        //Creation of the lame test nodes
        // *********************************************************

        Log.d(TAG, "Adding new view to centerNodes");
        LinearLayout centerNodes = (LinearLayout)findViewById(R.id.centerBarNodesLayout);
        centerNodes.addView(new NodeView(this,paul));
        Log.d(TAG, "Finished adding new view to centerNodes");

        int cC = centerNodes.getChildCount();
        Log.d(TAG, "Listing children...");

        for (int i = 0; i < cC; i++){

            Log.d("MainActivity", "Child number " + i + "'s visibility is " + centerNodes.getChildAt(i).getVisibility());
        }
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
