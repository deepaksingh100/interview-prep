package me.deepak.interview.graph;

import java.util.HashSet;
import java.util.Set;

public class Cyclic {

	private Cyclic() {
	}

	/*
	 * https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
	 */
	public static boolean isCyclic(Graph graph) {
		int vertexCount = graph.getVertexCount();
		boolean[] visited = new boolean[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			if (!visited[i] && isCyclic(graph, i, visited, -1)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isCyclic(Graph graph, int src, boolean[] visited, int adjacent) {

		// mark the current node as visited
		visited[src] = true;

		// recur for all the vertices adjacent to this vertex
		for (int i : graph.getAdjacencyList().get(src)) {

			if (!visited[i]) {

				// if an adjacent is not visited, then recur for that adjacent
				if (isCyclic(graph, i, visited, src)) {
					return true;
				}
			} else if (i != adjacent) {

				// if an adjacent is visited and not parent of current vertex, then there is a
				// cycle.
				return true;
			}
		}
		return false;
	}

	/*
	 * https://algorithms.tutorialhorizon.com/graph-detect-cycle-in-a-directed-graph
	 * -using-colors/
	 * https://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/
	 */
	public static boolean isCyclicDirected(Graph graph) {

		// unvisited vertices
		Set<Integer> whiteSet = new HashSet<>();

		// currently processing vertices
		Set<Integer> graySet = new HashSet<>();

		// visited vertices
		Set<Integer> blackSet = new HashSet<>();

		// initially put all vertices in white set
		for (int i = 0; i < graph.getVertexCount(); i++) {
			whiteSet.add(i);
		}

		// traverse only white vertices
		for (int i = 0; i < graph.getVertexCount(); i++) {
			if (whiteSet.contains(i) && isCyclicDirected(graph, i, whiteSet, graySet, blackSet)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCyclicDirected(Graph graph, int src, Set<Integer> whiteSet, Set<Integer> graySet,
			Set<Integer> blackSet) {

		// visiting this vertex, make it gray from white
		whiteSet.remove(src);
		graySet.add(src);

		// visit neighbors of src
		for (int i : graph.getAdjacencyList().get(src)) {

			// check if this vertex is present in gray set, means cycle is found
			if (graySet.contains(i)) {
				return true;
			}

			// check if this vertex is present in black set, means this vertex is already
			// done
			if (blackSet.contains(i)) {
				continue;
			}

			// do traversal from this vertex
			if (isCyclicDirected(graph, i, whiteSet, graySet, blackSet)) {
				return true;
			}
		}

		// if here, means cycle is not found from this vertex, make it black from gray
		graySet.remove(src);
		blackSet.add(src);
		return false;
	}

}
