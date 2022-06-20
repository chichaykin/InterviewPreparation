package facebook;

public class MatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        int aRows = A.length;
        int aCols = A[0].length;
        int bCols = B[0].length;

        int[][] result = new int[aRows][];
        for (int irow = 0; irow < aRows; irow++) {
            result[irow] = new int[bCols];
        }

        int irow = 0;
        for (int[] row : A) {
            for (int i = 0; i < aCols; i++) {
                result[irow][i] += B[i][irow] * row[i];
            }
            irow++;
        }

        return result;
    }
}
