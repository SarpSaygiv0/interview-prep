package com.medium.removeislands;

public class RemoveIslands {

    public int[][] removeIslands(int[][] matrix) {

        for (int i = 0; i < matrix[0].length; i++) {
            dfs(matrix, 0, i);                         // first row
            dfs(matrix, i, 0);                         // first column
            dfs(matrix, matrix.length - 1, i);        // last row
            dfs(matrix, i, matrix[0].length - 1);     // last column
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j] == 2 ? 1 : 0;
            }
        }

        return matrix;
    }

    private void dfs(int[][] matrix, int row, int col) {
        if (outOfBounds(row, col, matrix) || matrix[row][col] != 1)
            return;

        matrix[row][col] = 2;

        dfs(matrix, row - 1, col);
        dfs(matrix, row, col + 1);
        dfs(matrix, row + 1, col);
        dfs(matrix, row, col - 1);
    }

    private boolean outOfBounds(int row, int col, int[][] matrix) {
        boolean outOfRow = row < 0 || row >= matrix.length;
        boolean outOfCol = col < 0 || col >= matrix[0].length;
        return outOfRow || outOfCol;
    }

}
