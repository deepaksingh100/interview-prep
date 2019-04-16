package me.deepak.interview.graph;

public class ConnectedComponents {

	private Graph graph;

	public ConnectedComponents(Graph graph) {
		this.graph = graph;
	}

	public void connectedComponents() {
		int vertexCount = graph.getVertexCount();
		boolean[] isVisited = new boolean[vertexCount];
		for (int i = 0; i < vertexCount; i++) { // disjoint graph
			if (!isVisited[i]) {
				new DepthFirstTraversal(graph).depthFirstTraversal(i, isVisited);
				System.out.println();
			}
		}
	}

}
