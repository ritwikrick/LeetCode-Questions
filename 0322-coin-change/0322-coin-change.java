class Solution {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int result = solve(coins, amount, n, dp);

        return (result >= (int)1e9 ? -1 : result);
    }

    private int solve(int[] coins, int amount, int n, int[][] dp) {

        if (amount == 0) return 0;
        if (n == 0) return (int)1e9;  // impossible

        if (dp[n][amount] != -1)
            return dp[n][amount];

        if (coins[n - 1] <= amount) {

            // take (stay on same index because unlimited usage)
            int take = 1 + solve(coins, amount - coins[n - 1], n, dp);

            // skip (move to next coin)
            int skip = solve(coins, amount, n - 1, dp);

            return dp[n][amount] = Math.min(take, skip);
        }
        else {
            // can't take
            return dp[n][amount] = solve(coins, amount, n - 1, dp);
        }
    }
}
