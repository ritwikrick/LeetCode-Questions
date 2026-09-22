class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int len=0;
        int maxlen=0;
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            if(!map.containsKey(c) || map.get(c)<left){
                map.put(c,right);
                len=right-left+1;
                maxlen=Math.max(maxlen,len);
            }else{
                left=map.get(c)+1;
                map.put(c,right);
            }
        }
        return maxlen;
    }
}