package com.deepeagle.shanty.utils;

import java.util.HashMap;

import android.util.Log;

public class ShantyByteFormat {
	private final static String TAG = "shantyByteFormat";
	
	//HASHMAP
	private static HashMap<Integer,String> LETTERLOOKUP = new HashMap<Integer,String>(){{
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
		public String get(Object k) {
			return containsKey(k) ? super.get(k) : "S";
	}};
	
	
	public static String createUserID(byte[] encodedKey,int offset, int length){
		StringBuilder string = new StringBuilder();
		int key;
    	for(Integer i = offset-1; i < offset-1+length; i++ ){
    		//Log.d(TAG, "Byte intValue: " + ((Byte)encodedKey[i]).intValue());
    		key = Math.abs(((Byte)encodedKey[i]).intValue()) % 62;
    		string.append(LETTERLOOKUP.get(key));
    	}
		
    	return string.toString();
    }
	
	
	
	
	
	
	
	
	
	
	

}
