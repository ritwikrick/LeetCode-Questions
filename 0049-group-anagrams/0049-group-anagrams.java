import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        // Normal for-loop over input strings
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);                   // Sort characters
            String key = new String(chars);       // Convert back to string

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(strs[i]);
        }

        // Collect results using normal for-loop
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < keys.size(); i++) {
            result.add(map.get(keys.get(i)));
        }

        return result;
    }
}
