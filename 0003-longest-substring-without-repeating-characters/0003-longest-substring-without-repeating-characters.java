class Solution {
    public int lengthOfLongestSubstring(String s) {
        // if(s.length()==0){
        //     return 0;
        // }
        // int max=Integer.MIN_VALUE;
        // for(int i=0;i<s.length();i++){
        //     HashSet<Character> map=new HashSet<>();
        //     int len=0;
        //     for(int j=i;j<s.length();j++){
        //         if(map.contains(s.charAt(j))){
        //             break;
        //         }
        //         map.add(s.charAt(j));
        //         len=j-i+1;
        //     }
        //     max=Math.max(max,len);

        // }
        // return max;

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {
                // Move left only if needed
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right); // store latest index
            max = Math.max(max, right - left + 1);
        }

        return max;

    }
}