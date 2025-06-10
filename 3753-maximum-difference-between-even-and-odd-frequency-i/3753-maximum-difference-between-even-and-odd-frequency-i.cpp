class Solution {
public:
    int maxDifference(string s) {
        vector<int> freq(26, 0);
        
        // Step 1: Count frequencies of each character
        for (char c : s) {
            freq[c - 'a']++;
        }
        
        vector<int> oddFreqs;
        vector<int> evenFreqs;
        
        // Step 2: Separate frequencies into odd and even
        for (int f : freq) {
            if (f == 0) continue;
            if (f % 2 == 1)
                oddFreqs.push_back(f);
            else
                evenFreqs.push_back(f);
        }
        
        // Step 3: Compute max difference
        int maxDiff = INT_MIN;
        for (int odd : oddFreqs) {
            for (int even : evenFreqs) {
                maxDiff = max(maxDiff, odd - even);
            }
        }
        
        return maxDiff;
    }
};
