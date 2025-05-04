class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100]; // frequency array for normalized domino keys
        int res = 0;

        // Loop through all dominoes
        for (int i = 0; i < dominoes.length; i++) {
            // Normalize the domino: smaller number first, then larger
            int a = Math.min(dominoes[i][0], dominoes[i][1]);
            int b = Math.max(dominoes[i][0], dominoes[i][1]);
            int key = a * 10 + b; // Create a 2-digit key

            // Add the number of pairs we can form with the current domino
            res += count[key];

            // Increment the count of this normalized domino
            count[key]++;
        }

        return res; // Return the total number of pairs
    }
}
