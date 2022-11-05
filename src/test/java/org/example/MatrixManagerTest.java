package org.example;

import junit.framework.TestCase;
import static org.junit.Assert.assertArrayEquals;

public class MatrixManagerTest extends TestCase {

    public void testTranspose() {
        int [][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
        };

        int[][] expectedResult = {
                {1, 6},
                {2, 7},
                {3, 8},
                {4, 9},
                {5, 10},
        };

        assertArrayEquals(expectedResult, MatrixManager.transpose(matrix));
    }
}