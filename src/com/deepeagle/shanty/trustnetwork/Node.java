package com.deepeagle.shanty.trustnetwork;

import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.HashMap;

import com.deepeagle.shanty.utils.shantyByteFormat;

import android.util.Log;

/**
 * Created by Booty on 10/12/14.
 * This is the basic node interface, since both the PlayerNodes and UserNode are
 * essentially the same
 */
public interface Node {
	
	//Saved Data
	public PublicKey getPublicDecKey();
	public PublicKey getPublicEncKey();
	public String getTag();
	public String getAnnouncement();
	public String[] getPrivateMessages();
	public float getReliability();
	public float getTrust();
	
	//Computation Methods
	public byte[] getIdentity();
	public String getUserID();
	public String getUserIDTagged();

	
}
