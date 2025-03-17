class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int totalNumbers = n * n;
        
        // Frequency array
        int[] freq = new int[totalNumbers + 1];
        int repeating = -1, missing = -1;
        
        // Count occurrences
        for (int[] row : grid) {
            for (int num : row) {
                freq[num]++;
            }
        }
        
        // Identify the repeating and missing numbers
        for (int num = 1; num <= totalNumbers; num++) {
            if (freq[num] == 2) {
                repeating = num;
            } else if (freq[num] == 0) {
                missing = num;
            }
            if (repeating != -1 && missing != -1) break;
        }
        
        return new int[]{repeating, missing};
    }
}
