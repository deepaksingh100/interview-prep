package me.deepak.interview.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/graph-and-its-representations/
*/
public class Graph {

	private int vertexCount;
	private List<List<Integer>> adjacencyList;

	// initialize graph object
	public Graph(int vertexCount) {
		this.vertexCount = vertexCount;
		adjacencyList = new ArrayList<>();
	}

	// add an undirected edge between vertex1 & vertex2
	public void addEdge(int vertex1, int vertex2) {
		List<Integer> vertex1Adjacents = adjacencyList.get(vertex1);

		// if vertex1 has not any adjacents, create new LinkedList
		if (vertex1Adjacents == null) {
			vertex1Adjacents = new LinkedList<>();
		}

		// add vertex2 to adjacents of vertex1
		vertex1Adjacents.add(vertex2);
	}

	public int getVertexCount() {
		return vertexCount;
	}

	public List<List<Integer>> getAdjacencyList() {
		return adjacencyList;
	}

}
