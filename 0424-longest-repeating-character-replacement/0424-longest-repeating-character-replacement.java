class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int ans=0;
        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         int freq[]=new int[26];
        //         int maxf=0;
        //         for(int p=i;p<=j;p++){
        //             int idx=s.charAt(p)-'A';
        //             freq[idx]++;
        //             maxf=Math.max(maxf,freq[idx]);
        //         }
        //         int len=j-i+1;
        //         int change=len-maxf;
        //         if(change<=k){
        //             ans=Math.max(ans,len);
        //         }

        //     }
        // }
        int left=0;
        int maxf=0;
        int freq[]=new int[26];
        for(int right=0;right<s.length();right++){
            int idx=s.charAt(right)-'A';
            freq[idx]++;
            maxf=Math.max(maxf,freq[idx]);
            int len=right-left+1;
            if(len-maxf>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            ans=Math.max(ans,right-left+1);


        }
        return ans;
    }
}