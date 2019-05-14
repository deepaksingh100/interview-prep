package me.deepak.interview.graph;

public class ConnectedComponents {

	private ConnectedComponents() {
	}

	/*
	 * https://www.geeksforgeeks.org/connected-components-in-an-undirected-graph/
	 */
	public static void connectedComponents(Graph graph) {
		int vertexCount = graph.getVertexCount();

		// mark all the vertices as not visited
		boolean[] isVisited = new boolean[vertexCount];

		for (int i = 0; i < vertexCount; i++) {
			if (!isVisited[i]) {

				// print all reachable vertices from i
				Traversals.depthFirst(graph, i, isVisited);
				System.out.println();
			}
		}
	}

}
