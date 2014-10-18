package com.deepeagle.shanty.trustnetwork;

import org.jgrapht.DirectedGraph;
import org.jgrapht.EdgeFactory;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

/**
 * 
 * @author Booty
 * Contains a list of nodes with edges indicating their respective levels of trust and 
 * reliability
 */
public class NodeGraph extends DefaultDirectedWeightedGraph<ShantyVertex, DefaultWeightedEdge> implements java.io.Serializable{
	
	
	private static final long serialVersionUID = 1L;


	public NodeGraph(EdgeFactory<ShantyVertex, DefaultWeightedEdge> ef) {
		super(ef);
	}
	
	

	


	
	

}
