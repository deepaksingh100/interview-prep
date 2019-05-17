package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/flood-fill/
*/
public class FloodFill {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image == null || image.length == 0 || image[0].length == 0) {
			return image;
		}
		int oldColor = image[sr][sc];
		if (oldColor != newColor) {
			dfs(image, sr, sc, oldColor, newColor);
		}
		return image;
	}

	private void dfs(int[][] image, int i, int j, int oldColor, int newColor) {
		if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != oldColor) {
			return;
		}
		image[i][j] = newColor;
		dfs(image, i - 1, j, oldColor, newColor);
		dfs(image, i + 1, j, oldColor, newColor);
		dfs(image, i, j - 1, oldColor, newColor);
		dfs(image, i, j + 1, oldColor, newColor);
	}

}
