import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {
                // Move left only forward
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right); // update latest index
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
