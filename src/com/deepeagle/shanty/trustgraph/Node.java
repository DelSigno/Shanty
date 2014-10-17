package com.deepeagle.shanty.trustgraph;

import java.lang.reflect.Array;
import java.security.PublicKey;

/**
 * Created by Booty on 10/12/14.
 */
public class Node {

    private final PublicKey decrypyionKey;
    private final PublicKey encryptionKey;

    private final String announcement;
    private final String[] privateMessages;

    public Node(PublicKey decKey, PublicKey encKey, String announ, String PMs[]){
        this.decrypyionKey = decKey;
        this.encryptionKey = encKey;
        this.announcement = announ;
        this.privateMessages = PMs;

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
        //Stores the number of bytes in the de/encryption key
        int decKeyLength = Array.getLength(decrypyionKey.getEncoded());
        int encKeyLength = Array.getLength(encryptionKey.getEncoded());

        String userID = Byte.toString(getDecryptionKey().getEncoded()[decKeyLength-5]) +
                        Byte.toString(getDecryptionKey().getEncoded()[decKeyLength-2]) +
                        Byte.toString(getDecryptionKey().getEncoded()[decKeyLength-3]) +
                        Byte.toString(getDecryptionKey().getEncoded()[decKeyLength-2]) +
                        Byte.toString(getDecryptionKey().getEncoded()[decKeyLength-1]) +
                        Byte.toString(getEncryptionKey().getEncoded()[encKeyLength-5]) +
                        Byte.toString(getEncryptionKey().getEncoded()[encKeyLength-4]) +
                        Byte.toString(getEncryptionKey().getEncoded()[encKeyLength-3]) +
                        Byte.toString(getEncryptionKey().getEncoded()[encKeyLength-2]) +
                        Byte.toString(getEncryptionKey().getEncoded()[encKeyLength-1]);
        return userID;
    }






}
