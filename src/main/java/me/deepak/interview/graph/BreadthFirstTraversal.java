package me.deepak.interview.graph;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class BreadthFirstTraversal {

	private int vertexCount;
	private List<Integer>[] adjacencyList;

	public BreadthFirstTraversal(Graph graph) {
		vertexCount = graph.getVertexCount();
		adjacencyList = graph.getAdjacencyList();
	}

	public void breadthFirstTraversal(int src) {
		boolean[] isVisited = new boolean[vertexCount];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(src);
		isVisited[src] = true;
		while (!queue.isEmpty()) {
			src = queue.remove();
			System.out.print(src + " ");
			for (int i : adjacencyList[src]) {
				if (!isVisited[i]) {
					queue.add(i);
					isVisited[i] = true;
				}
			}
		}
	}

}
