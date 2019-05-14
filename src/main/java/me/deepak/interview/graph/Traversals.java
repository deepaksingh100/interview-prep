package me.deepak.interview.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Traversals {

	private Traversals() {
	}

	/*
	 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
	 */
	public static void breadthFirst(Graph graph, int src) {

		// mark all the vertices as not visited (by default set as false)
		boolean[] visited = new boolean[graph.getVertexCount()];

		// create a queue for BFS
		Queue<Integer> queue = new ArrayDeque<>();

		// mark the current node as visited and enqueue it
		queue.add(src);
		visited[src] = true;

		while (!queue.isEmpty()) {

			// dequeue a vertex from queue and print it
			src = queue.remove();
			System.out.print(src + " ");

			// Get all adjacent vertices of the dequeued vertex src. If an adjacent has not
			// been visited, then mark it visited and enqueue it
			for (int i : graph.getAdjacencyList().get(src)) {
				if (!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}

	/*
	 * https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
	 */
	public static void depthFirst(Graph graph, int src) {

		// mark all the vertices as not visited (set as false by default in java)
		boolean[] visited = new boolean[graph.getVertexCount()];

		// call the recursive helper function to print DFS traversal
		depthFirst(graph, src, visited);
	}

	public static void depthFirst(Graph graph, int src, boolean[] visited) {

		// mark the current node as visited and print it
		visited[src] = true;
		System.out.print(src + " ");

		// recur for all the vertices adjacent to this vertex (that are not visited)
		for (int i : graph.getAdjacencyList().get(src)) {
			if (!visited[i]) {
				depthFirst(graph, i, visited);
			}
		}
	}

	/*
	 * https://www.geeksforgeeks.org/iterative-depth-first-traversal/
	 */
	public static void depthFirstIterative(Graph graph, int src) {

		// initially mark all vertices as not visited
		boolean[] visited = new boolean[graph.getVertexCount()];

		// create a stack for DFS
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		// push the current source node
		stack.push(src);

		while (!stack.isEmpty()) {

			// pop a vertex from stack and print it
			src = stack.pop();

			// Stack may contain same vertex twice. So we need to print the popped item only
			// if it is not visited.
			if (!visited[src]) {
				visited[src] = true;
				System.out.print(src + " ");
			}

			// Get all adjacent vertices of the popped vertex src. If an adjacent has not
			// been visited, then push it to the stack.
			for (int i : graph.getAdjacencyList().get(src)) {
				if (!visited[i]) {
					stack.push(i);
				}
			}
		}
	}

}
