package com.deepeagle.shanty.trustnetwork;

import org.jgrapht.EdgeFactory;
import org.jgrapht.graph.DefaultWeightedEdge;

public class ShantyEdgeFactory implements EdgeFactory<ShantyVertex, DefaultWeightedEdge> {

	@Override
	public ShantyEdge createEdge(ShantyVertex sourceVertex, ShantyVertex targetVertex) {
		return new ShantyEdge(sourceVertex, targetVertex);
		
	}


}
