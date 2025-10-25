// class Solution {
//     public String minWindow(String s, String t) {
//         HashMap<Character, Integer> originalMap = new HashMap<>();
//         int sIndex=-1,minlen=Integer.MAX_VALUE;
//         int m=t.length();
//         int n=s.length();
//         for(int i=0;i<m;i++){
//             char ch=t.charAt(i);
//             originalMap.put(ch, originalMap.getOrDefault(ch, 0) + 1);
//         }
//         for(int i=0;i<n;i++){
//             int c=0;
//             HashMap<Character, Integer> map = new HashMap<>(originalMap);
//             for(int j=i;j<n;j++){
//                 char ch=s.charAt(j);
//                 if(map.containsKey(ch) && map.get(ch)>0){
//                     c++;
//                     map.put(ch,map.get(ch)-1);
//                 }
//                 if(c==m){
//                     if(minlen>j-i+1){
//                         minlen=j-i+1;
//                         sIndex=i;
//                     }
//                     break;
//                 }
//             }
//         }
//         if (minlen == Integer.MAX_VALUE) return "";
//         return s.substring(sIndex, sIndex + minlen);

//     }
// }
////////////////////////
class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        if (n == 0 || t.length() == 0) return "";

        // Step 1: Build frequency map of characters in t
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Initialize pointers and variables
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE, startIdx = 0;
        int count = 0;  // Number of characters from t matched so far

        // Step 3: Expand the window
        while (right < n) {
            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);

                // ✅ Strict >0 logic: increment count only if char was still needed
                if (map.get(ch) >= 0) count++;
            }

            // Step 4: Shrink window from left while all chars matched
            while (count == t.length()) {
                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }

                char leftChar = s.charAt(left);

                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);

                    // If putting back makes it needed, decrement count
                    if (map.get(leftChar) > 0) count--;
                }

                left++; // Shrink window
            }

            right++; // Expand window
        }

        // Step 5: Return result
        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
