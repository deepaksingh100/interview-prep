package me.deepak.interview.graph;

public class ValidTree {

	private ValidTree() {
	}

	/*
	 * https://www.geeksforgeeks.org/check-given-graph-tree/
	 */
	public static boolean isTree(Graph graph) {
		boolean[] isVisited = new boolean[graph.getVertexCount()];

		// if graph is cyclic, it can't be tree
		if (Cyclic.isCyclic(graph, 0, isVisited, -1)) {
			return false;
		}

		// if any vertex is not connected, graph can't be tree
		for (boolean b : isVisited) {
			if (!b) {
				return false;
			}
		}
		return true;
	}

}
