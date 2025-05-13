class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1_000_000_007;
        long[] freq = new long[26];  // Frequency of characters 'a' to 'z'
        
        // Initialize frequency array
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Perform t transformations
        for (int step = 0; step < t; step++) {
            long[] nextFreq = new long[26];
            for (int i = 0; i < 26; i++) {
                if (i < 25) {
                    nextFreq[i + 1] = (nextFreq[i + 1] + freq[i]) % MOD;
                } else {
                    // 'z' becomes 'a' and 'b'
                    nextFreq[0] = (nextFreq[0] + freq[25]) % MOD;
                    nextFreq[1] = (nextFreq[1] + freq[25]) % MOD;
                }
            }
            freq = nextFreq;
        }

        // Sum total characters
        long result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + freq[i]) % MOD;
        }

        return (int) result;
    }
}