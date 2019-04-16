package me.deepak.interview.graph;

import java.util.ArrayDeque;
import java.util.List;

public class DepthFirstTraversal {

	private int vertexCount;
	private List<Integer>[] adjacencyList;

	public DepthFirstTraversal(Graph graph) {
		vertexCount = graph.getVertexCount();
		adjacencyList = graph.getAdjacencyList();
	}

	public void depthFirstTraversal(int src) {
		boolean[] isVisited = new boolean[vertexCount];
		depthFirstTraversal(src, isVisited);
	}

	public void depthFirstTraversal(int src, boolean[] isVisited) {
		isVisited[src] = true;
		System.out.print(src + " ");
		for (int i : adjacencyList[src]) {
			if (!isVisited[i]) {
				depthFirstTraversal(i, isVisited);
			}
		}
	}

	public void depthFirstTraversalIterative(int src) {
		boolean[] isVisited = new boolean[vertexCount];
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(src);
		while (!stack.isEmpty()) {
			src = stack.pop();
			if (!isVisited[src]) {
				isVisited[src] = true;
				System.out.print(src + " ");
			}
			for (int i : adjacencyList[src]) {
				if (!isVisited[i]) {
					stack.push(i);
				}
			}
		}
	}

}
