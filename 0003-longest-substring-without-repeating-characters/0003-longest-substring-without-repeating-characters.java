// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         HashMap<Character,Integer> map=new HashMap<>();
//         int left=0;
//         int maxlen=0;
//         for(int right=0;right<s.length();right++){
//             char ch=s.charAt(right);
//             if(!map.containsKey(ch) || map.get(ch)<left){
//                 map.put(ch,right);
//                 maxlen=Math.max(maxlen,right-left+1);
//             }else {
//                 left=map.get(ch)+1;
//                 map.put(ch,right);
//             }
            
//         }
//         return maxlen;
//     }
// }
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashMap<Character,Integer> map=new HashMap<>();
        // int maxlen=0;
        // int left=0;
        // for(int right=0;right<s.length();right++){
        //     char ch=s.charAt(right);
        //     if(!map.containsKey(ch)  || map.get(ch)<left){
        //         map.put(ch,right);
        //         maxlen=Math.max(maxlen,right-left+1);
        //     }else{
        //         left=map.get(ch)+1;
        //         map.put(ch,right);
        //     }
        // }
        // return maxlen;

        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int maxlen=0;
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            if(!map.containsKey(ch) || map.get(ch)<left){
                map.put(ch,r);
                maxlen=Math.max(maxlen,r-left+1);
            }else{
                left=map.get(ch)+1;
                map.put(ch,r);
            }
        }
        return maxlen;



    }
}