class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            HashSet<Character> map=new HashSet<>();
            int len=0;
            for(int j=i;j<s.length();j++){
                if(map.contains(s.charAt(j))){
                    break;
                }
                map.add(s.charAt(j));
                len=j-i+1;
            }
            max=Math.max(max,len);

        }
        return max;
    }
}