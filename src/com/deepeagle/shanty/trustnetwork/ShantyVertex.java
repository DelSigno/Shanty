package com.deepeagle.shanty.trustnetwork;

import java.io.Serializable;

public class ShantyVertex implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3318157475031771362L;
	
	private final Node node;
	public ShantyVertex(Node node){
		this.node = node;
	}
	
	public Node getNode(){
		return node;
	}

}
