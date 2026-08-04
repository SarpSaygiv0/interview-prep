package com.medium.riversizes;

import java.util.ArrayList;
import java.util.List;

public class RiverSizes {

    public List<Integer> riverSizes(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1)
                    result.add(riverSizeCounter(matrix, i, j));
            }
        }

        return result;
    }

    private int riverSizeCounter(int[][] matrix, int row, int col) {
        if (outOfBounds(matrix, row, col) || matrix[row][col] != 1) return 0;

        matrix[row][col] = 2;

        return 1 + riverSizeCounter(matrix, row - 1, col)
                + riverSizeCounter(matrix, row, col + 1)
                + riverSizeCounter(matrix, row + 1, col)
                + riverSizeCounter(matrix, row, col - 1);
    }

    private boolean outOfBounds(int[][] matrix, int row, int column) {
        boolean outOfRow = row < 0 || row >= matrix.length;
        boolean outOfColumn = column < 0 || column >= matrix[0].length;
        return outOfRow || outOfColumn;
    }
}
