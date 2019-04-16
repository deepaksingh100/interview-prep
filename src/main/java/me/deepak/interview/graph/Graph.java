package me.deepak.interview.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Graph {

	private int vertexCount;
	private List<Integer>[] adjacencyList;

	public Graph(int vertexCount) {
		this.vertexCount = vertexCount;
		adjacencyList = new LinkedList[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			adjacencyList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int vertex1, int vertex2) {
		adjacencyList[vertex1].add(vertex2);
	}

	public int getVertexCount() {
		return vertexCount;
	}

	public List<Integer>[] getAdjacencyList() {
		return adjacencyList;
	}

	public boolean isTree() {
		boolean[] isVisited = new boolean[vertexCount];
		if (isCyclic(0, isVisited, -1)) {
			return false;
		}
		for (boolean b : isVisited) {
			if (!b) {
				return false;
			}
		}
		return true;
	}

	public boolean isCyclic() {
		boolean[] isVisited = new boolean[vertexCount];
		for (int i = 0; i < vertexCount; i++) { // disjoint graph
			if (!isVisited[i] && isCyclic(i, isVisited, -1)) {
				return true;
			}
		}
		return false;
	}

	private boolean isCyclic(int src, boolean[] isVisited, int adjacent) {
		isVisited[src] = true;
		for (int i : adjacencyList[src]) {
			if (!isVisited[i]) {
				if (isCyclic(i, isVisited, src)) {
					return true;
				}
			} else if (i != adjacent) {
				return true;
			}
		}
		return false;
	}

	public boolean isCyclicDirected() {
		Set<Integer> whiteSet = new HashSet<>();
		Set<Integer> graySet = new HashSet<>();
		Set<Integer> blackSet = new HashSet<>();
		for (int i = 0; i < vertexCount; i++) {
			whiteSet.add(i);
		}
		for (int i = 0; i < vertexCount; i++) {
			if (whiteSet.contains(i) && isCyclicDirected(i, whiteSet, graySet, blackSet)) {
				return true;
			}
		}
		return false;
	}

	private boolean isCyclicDirected(int src, Set<Integer> whiteSet, Set<Integer> graySet, Set<Integer> blackSet) {
		whiteSet.remove(src);
		graySet.add(src);
		for (int i : adjacencyList[src]) {
			if (graySet.contains(i)) {
				return true;
			}
			if (blackSet.contains(i)) {
				continue;
			}
			if (isCyclicDirected(i, whiteSet, graySet, blackSet)) {
				return true;
			}
		}
		graySet.remove(src);
		blackSet.add(src);
		return false;
	}

}
