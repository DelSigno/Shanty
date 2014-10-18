package com.deepeagle.shanty.trustnetwork;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import android.util.Log;

import com.deepeagle.shanty.utils.ShantyByteFormat;
import com.deepeagle.shanty.utils.ShantyRand;

/**
 * 
 * @author Booty
 * This is the UserNode, this represents "You" as a player in the network. This is where
 * your personal setting will be contained. As the user you can control over what your PMs
 * and accouncements are, all that good stuff
 * 
 */
public class UserNode implements Serializable, Node{


	private static final long serialVersionUID = 1L;
	private static final String TAG = "UserNode";

	
	
	/*
	 * These are the generated RSA keys that give "accounts" their
	 * uniqueness. They are created only once and from that point on
	 * will become your identity until killed
	 */
	private final PrivateKey privateDecryptionKey;
	private final PrivateKey privateEncryptionKey;
    private final PublicKey publicDecryptionKey;
    private final PublicKey publicEncryptionKey;
    
    
    /*
     * These variables are used for communication with other users
     * they can be changed at the users discresion.
     */
    private String announcement;
    private String tag;
    private String[] privateMessages;
    private float reliability;
    private float trust;
    

    /*
     * Creates the user node. This should be called once per new account creation. 
     * After that point serialized and 
     */
    public UserNode(){
    	//**********************************************************
        //Creation of a Users Node
        // *********************************************************
    	KeyPairGenerator keyGen = null;
        KeyPair decryptionPair;
        KeyPair encryptionPair;

        try {
            keyGen = KeyPairGenerator.getInstance("RSA");
        }catch(NoSuchAlgorithmException e){
            Log.d(TAG,"Was not able to find RSA algoritm, something is very wrong");
            //return;
        }

        //Keysize will normally be 2048, 512 for quicker compiling at early stages
        keyGen.initialize(2048);
        Log.d(TAG, "Generating keys");
        //Generates and stores keys.
        //We use private major notation
        decryptionPair = keyGen.generateKeyPair();
        encryptionPair = keyGen.generateKeyPair(); 
        this.privateDecryptionKey = decryptionPair.getPrivate();
        this.publicEncryptionKey = decryptionPair.getPublic();
        this.privateEncryptionKey = encryptionPair.getPrivate();
        this.publicDecryptionKey = encryptionPair.getPublic();
        
        
        
    }

	@Override
	public PublicKey getPublicDecKey() {
		return publicDecryptionKey;
	}

	@Override
	public PublicKey getPublicEncKey() {
		return publicEncryptionKey;
	}

	@Override
	public String getTag() {
		return tag;
	}

	public boolean setAccouncment(String newAnnouncement){
		//if newAnnouncement.length() 
		return true;
	}
	
	@Override
	public String getAnnouncement() {
		return announcement;
	}

	@Override
	public String[] getPrivateMessages() {
		return privateMessages;
	}

	@Override
	public float getReliability() {
		//We consider ourselves fully reliable
		return 1;
	}

	@Override
	public float getTrust() {
		//We consider ourselves fully trustworthy
		return 1;
	}

	@Override
	public byte[] getIdentity() {
		//Combines the two keys to produce one unique identifier
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
        try {
			outputStream.write(publicDecryptionKey.getEncoded());
			outputStream.write(publicEncryptionKey.getEncoded());
		} catch (IOException e) {
		}
        return outputStream.toByteArray();
	}

	@Override
	public String getUserID() {
		return ShantyByteFormat.createUserID(publicDecryptionKey.getEncoded(), 50, 4) +
    			ShantyByteFormat.createUserID(publicEncryptionKey.getEncoded(), 50, 4);
	}

	@Override
	public String getUserIDTagged() {
		return getUserID() + tag;
	}

}
