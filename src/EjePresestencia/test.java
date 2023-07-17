package EjePresestencia;

import org.junit.Assert;
import org.junit.Test;

public class test {
    @Test
    public void testMultiplicarMatrizes() {
        int[][] matrix1 = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[][] matrix2 = {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        int[][] expected = {{6,6,6},{6,6,6},{6,6,6}};

        int[][] result = MultiplicarMatrices.multiplicarMatrizes(matrix1, matrix2);

        Assert.assertArrayEquals(expected, result);
    }
}
