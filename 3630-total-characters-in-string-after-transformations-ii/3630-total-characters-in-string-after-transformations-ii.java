import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[][] matrix = new int[26][26];

        // Step 1: Build the transformation matrix
        for (int i = 0; i < 26; i++) {
            int count = nums.get(i);
            for (int j = 1; j <= count; j++) {
                int nextChar = (i + j) % 26;
                matrix[i][nextChar] = (matrix[i][nextChar] + 1) % MOD;
            }
        }

        // Step 2: Matrix exponentiation to power t
        int[][] poweredMatrix = matrixPower(matrix, t);

        // Step 3: Multiply powered matrix with initial state vector [1,1,...,1]
        int[] finalCharCount = multiplyMatrixVector(poweredMatrix, new int[26]);

        // Step 4: Sum the final counts for each character in the input string
        long result = 0;
        for (char c : s.toCharArray()) {
            result = (result + finalCharCount[c - 'a']) % MOD;
        }

        return (int) result;
    }

    private int[][] matrixMultiply(int[][] A, int[][] B) {
        int[][] result = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < 26; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < 26; j++) {
                    result[i][j] = (int) ((result[i][j] + 1L * A[i][k] * B[k][j]) % MOD);
                }
            }
        }
        return result;
    }

    private int[][] matrixPower(int[][] matrix, int power) {
        int[][] result = new int[26][26];
        for (int i = 0; i < 26; i++) result[i][i] = 1;  // identity matrix

        while (power > 0) {
            if ((power & 1) == 1) {
                result = matrixMultiply(result, matrix);
            }
            matrix = matrixMultiply(matrix, matrix);
            power >>= 1;
        }

        return result;
    }

    private int[] multiplyMatrixVector(int[][] matrix, int[] vector) {
        int[] result = new int[26];
        Arrays.fill(vector, 1); // initial character count is 1 for each letter

        for (int i = 0; i < 26; i++) {
            long sum = 0;
            for (int j = 0; j < 26; j++) {
                sum = (sum + 1L * matrix[i][j] * vector[j]) % MOD;
            }
            result[i] = (int) sum;
        }

        return result;
    }
}