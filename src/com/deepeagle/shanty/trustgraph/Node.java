package com.deepeagle.shanty.trustgraph;

import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.HashMap;

import android.util.Log;

/**
 * Created by Booty on 10/12/14.
 */
public class Node {

	private final static String TAG = "Node";
    private final PublicKey decrypyionKey;
    private final PublicKey encryptionKey;
    private final String userID;

    private String announcement;
    private String tag;
    private String[] privateMessages;

    public Node(PublicKey decKey, PublicKey encKey, String announ, String PMs[], String tag){
        this.decrypyionKey = decKey;
        this.encryptionKey = encKey;
        this.announcement = announ;
        this.privateMessages = PMs;
        this.tag = tag;
        
        
        //Stores the number of bytes in the de/encryption key
        int decKeyLength = Array.getLength(decrypyionKey.getEncoded());
        int encKeyLength = Array.getLength(encryptionKey.getEncoded());
        Log.d(TAG, "Decryption key length in bytes: " + decKeyLength);
        Log.d(TAG, "Encryption key length in bytes: " + encKeyLength);
        this.userID = new String(decrypyionKey.getEncoded(), 50, 5) +
					new String(encryptionKey.getEncoded(), 50, 5);

    }

    public PublicKey getDecryptionKey(){
        return decrypyionKey;
    }

    public PublicKey getEncryptionKey(){
        return encryptionKey;
    }

    public String getAnnouncement(){
        return announcement;
    }

    public String[] getPrivateMessages(){
        return privateMessages;
    }

    public String getUserID(){  	
        return userID;
    }

    public String getUserIDTagged(){
    	return userID+tag;
    }
    
    private String createUserID(byte[] encodedKey){
    	//HASHMAP
    	HashMap<Integer,String> letterLookup = new HashMap<Integer,String>(){{
    		put(0,"0");put(1,"1");put(2,"2");put(3,"3");put(4,"4");put(5,"5");put(6,"6");
    		put(7,"7");put(8,"8");put(9,"9");put(10,"a");put(11,"b");put(12,"c");put(13,"d");
    		put(14,"e");put(15,"f");put(16,"g");put(17,"h");put(18,"i");put(19,"j");put(20,"k");
    		put(21,"l");put(22,"m");put(23,"n");put(24,"o");put(25,"p");put(26,"q");put(27,"r");
    		put(28,"s");put(29,"t");put(30,"u");put(31,"v");put(32,"w");put(33,"x");put(34,"y");
    		put(35,"z");put(36,"A");put(37,"B");put(38,"C");put(39,"D");put(40,"E");put(41,"F");
    		put(42,"G");put(43,"H");put(44,"I");put(45,"J");put(46,"K");put(47,"L");put(48,"M");
    		put(49,"N");put(50,"O");put(51,"P");put(52,"Q");put(53,"R");put(54,"S");put(55,"T");
    		put(56,"U");put(57,"V");put(58,"W");put(59,"X");put(60,"Y");put(61,"Z");
    		}
    		@Override
    		public Integer get(Object k) {
    			return containsKey(k) ? super.get(k) : 63;
    	}};
    	return null;
    }
    






}
