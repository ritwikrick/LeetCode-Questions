class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        // dp[i] = length of longest valid subsequence ending at i
        int[] dp = new int[n];
        // prev[i] = index of the previous word in that subsequence (or -1)
        int[] prev = new int[n];
        
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        
        int bestLen = 1;
        int bestEnd = 0;
        
        for (int i = 0; i < n; i++) {
            // try to append words[i] after any words[j] with j < i
            for (int j = 0; j < i; j++) {
                // Group must differ
                if (groups[i] == groups[j]) continue;
                // Length must be equal
                if (words[i].length() != words[j].length()) continue;
                // Hamming distance must be exactly 1
                if (hammingDistance(words[i], words[j]) != 1) continue;
                
                if (dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            // Track the overall best
            if (dp[i] > bestLen) {
                bestLen = dp[i];
                bestEnd = i;
            }
        }
        
        // Reconstruct the subsequence by walking prev[]
        LinkedList<String> answer = new LinkedList<>();
        int cur = bestEnd;
        while (cur != -1) {
            answer.addFirst(words[cur]);
            cur = prev[cur];
        }
        
        return answer;
    }
    
    // Compute Hamming distance between two same-length strings
    private int hammingDistance(String a, String b) {
        int dist = 0;
        for (int k = 0; k < a.length(); k++) {
            if (a.charAt(k) != b.charAt(k)) {
                dist++;
                // early exit if >1
                if (dist > 1) return dist;
            }
        }
        return dist;
    }
}
