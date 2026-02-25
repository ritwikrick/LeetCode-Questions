// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         if (s1.length() > s2.length()) return false;

//         Map<Character, Integer> map1 = new HashMap<>();
//         Map<Character, Integer> map2 = new HashMap<>();

//         for (char c : s1.toCharArray()) map1.put(c, map1.getOrDefault(c, 0) + 1);

//         int window = s1.length();
//         for (int i = 0; i < s2.length(); i++) {
//             char c = s2.charAt(i);
//             map2.put(c, map2.getOrDefault(c, 0) + 1);

//             if (i >= window) {
//                 char left = s2.charAt(i - window);
//                 map2.put(left, map2.get(left) - 1);
//                 if (map2.get(left) == 0) map2.remove(left);
//             }

//             if (map1.equals(map2)) return true;
//         }

//         return false;
//     }
// }

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // if (s1.length() > s2.length()) return false;

        // int[] s1Count = new int[26];
        // int[] windowCount = new int[26];

        // // Count chars in s1
        // for (char c : s1.toCharArray()) {
        //     s1Count[c - 'a']++;
        // }

        // int len = s1.length();

        // for (int i = 0; i < s2.length(); i++) {
        //     windowCount[s2.charAt(i) - 'a']++;

        //     // Keep the window size fixed
        //     if (i >= len) {
        //         windowCount[s2.charAt(i - len) - 'a']--;
        //     }

        //     // Compare arrays
        //     if (Arrays.equals(s1Count, windowCount)) return true;
        // }

        // return false;

        int n=s1.length();
        boolean flag=false;
        for(int i=0;i<s2.length();i++){
            if(s2.length()-i>=s1.length()){
                String subs=s2.substring(i,i+n);
                if(check(subs,s1)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean check(String subs, String s1){
        int freq[]=new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<subs.length();i++){
            freq[subs.charAt(i)-'a']--;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    } 
}

