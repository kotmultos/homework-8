package org.example;

public class MatrixManager {
    public static int [][] transpose(int [][] matrix) {
        int [][] res = new int[0][0];
        try {
            res = new int[matrix[0].length][matrix.length];

            for (int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[i].length; j++) {
                    res[j][i] = matrix[i][j];
                }
            }
        }
        catch (IndexOutOfBoundsException e1) {
            System.out.println(e1);
        }

        return res;
    }
}
