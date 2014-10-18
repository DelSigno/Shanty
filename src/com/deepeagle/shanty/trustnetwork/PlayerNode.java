package com.deepeagle.shanty.trustnetwork;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.PublicKey;

import android.util.Log;

import com.deepeagle.shanty.utils.shantyByteFormat;

/**
 * 
 * @author Booty
 * The PlayerNode is the node reserved for nodes other they yourself
 * these are just called players. 
 *
 */

public class PlayerNode implements Node{

	private final static String TAG = "Node";
    private final PublicKey decrypyionKey;
    private final PublicKey encryptionKey;
    private final byte[] identity;
    
    private String announcement;
    private String tag;
    private String[] privateMessages;
    private float reliability;
    private float trust;

    public PlayerNode(PublicKey decKey, PublicKey encKey, String announ, String PMs[], String tag){
        this.decrypyionKey = decKey;
        this.encryptionKey = encKey;
        
        //Combines the two keys to produce one unique identifier
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
        try {
			outputStream.write(decrypyionKey.getEncoded());
			outputStream.write(encryptionKey.getEncoded());
		} catch (IOException e) {
		}
        this.identity = outputStream.toByteArray();
        this.announcement = announ;
        this.privateMessages = PMs;
        this.tag = tag;

    }

    
    public String getAnnouncement(){
        return announcement;
    }

    public String[] getPrivateMessages(){
        return privateMessages;
    }

    public String getUserID(){  	
        //Stores the number of bytes in the de/encryption key
        //int decKeyLength = Array.getLength(decrypyionKey.getEncoded());
        //int encKeyLength = Array.getLength(encryptionKey.getEncoded());
        //Log.d(TAG, "Decryption key length in bytes: " + decKeyLength);
        //Log.d(TAG, "Encryption key length in bytes: " + encKeyLength);
        return shantyByteFormat.createUserID(decrypyionKey.getEncoded(), 50, 4) +
        			shantyByteFormat.createUserID(encryptionKey.getEncoded(), 50, 4);
    }

    public String getUserIDTagged(){
    	return getUserID()+tag;
    }

	@Override
	public PublicKey getPublicDecKey() {
		return decrypyionKey;
	}

	@Override
	public PublicKey getPublicEncKey() {
		return encryptionKey;
	}

	@Override
	public String getTag() {
		return tag;
	}

	@Override
	public float getReliability() {
		return reliability;
	}

	@Override
	public float getTrust() {
		return trust;
	}

	@Override
	public byte[] getIdentity() {
		return identity;
	}
    
    
    






}
