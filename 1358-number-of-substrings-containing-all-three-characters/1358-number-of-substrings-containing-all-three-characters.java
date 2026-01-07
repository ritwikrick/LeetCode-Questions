// class Solution {
//     public int numberOfSubstrings(String s) {
//         // int n=s.length(); O(N2)
//         // int len=0;
//         // for(int i=0;i<n;i++){
//         //     HashMap<Character,Integer> map=new HashMap<>();
//         //     for(int j=i;j<n;j++){
//         //         char ch=s.charAt(j);
//         //         map.put(ch,map.getOrDefault(ch,0)+1);
//         //         if(map.size()>=3){
//         //             len+=(n-j); //small optimization here
//         //             break;
//         //         }
//         //     }
            
//         // }
//        // return len;
//     }
// }
class Solution {
    public int numberOfSubstrings(String s) {
        // int len = 0;
        // int[] arr = {-1, -1, -1};  // track latest index of a,b,c

        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        //     arr[ch - 'a'] = i;

        //     if (arr[0] != -1 && arr[1] != -1 && arr[2] != -1) {
        //         len += Math.min(arr[0], Math.min(arr[1], arr[2])) + 1;
        //     }
        // }
        // return len;


        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int count=0;
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);

            while(map.size()==3){
                count += s.length() - right;
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
        }
        return count;
    }
}
