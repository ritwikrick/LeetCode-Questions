class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int[] freq = new int[size + 1];  // Index from 1 to n^2

        // Count frequency of each number in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                freq[val]++;
            }
        }

        int repeated = -1;
        int missing = -1;

        // Find repeated and missing numbers
        for (int i = 1; i <= size; i++) {
            if (freq[i] == 2) {
                repeated = i;
            } else if (freq[i] == 0) {
                missing = i;
            }
        }

        return new int[]{repeated, missing};
    }
}
