package com.deepeagle.shanty.trustnetwork;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;

/**
 * 
 * @author Booty
 * Contains a list of nodes with edges indicating their respective levels of trust and 
 * reliability
 */
public class NodeGraph extends DefaultDirectedWeightedGraph<ShantyVertex, ShantyEdge> implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public NodeGraph(Class edgeClass) {
		super(edgeClass);
		// TODO Auto-generated constructor stub
	}

	
	

}
