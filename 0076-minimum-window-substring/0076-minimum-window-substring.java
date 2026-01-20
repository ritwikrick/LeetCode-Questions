class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder ans=new StringBuilder();
        int left=0;
        int minlen=Integer.MAX_VALUE;
        int count=map.size();
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0) count--;
            }
            while(count==0){
                if(right-left+1<minlen){
                    minlen=right-left+1;
                    String sb=s.substring(left,right+1);
                    ans=new StringBuilder(sb);
                }
                char l=s.charAt(left);
                if(map.containsKey(l)){
                    map.put(l,map.get(l)+1);
                   if(map.get(l)>0)  count++;
                }
                left++;
            }
            
        }
        return ans.toString();
    }
}