class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
    //     return lcs(text1,text2,len1,len2);
        
    // }
    // public int lcs(String str1,String str2,int m,int n){
    //     if(m==0 || n==0){
    //         return 0;
    //     }
    //     if(str1.charAt(m-1) == str2.charAt(n-1)){
    //         return lcs(str1,str2,m-1,n-1)+1;
    //     }
    //     int ch1=lcs(str1,str2,m,n-1);
    //     int ch2=lcs(str1,str2,m-1,n);
    //     return Math.max(ch1,ch2);

        int dp[][]=new int[len1+1][len2+1];
        for(int i=0;i<=text1.length();i++){
            for(int j=0;j<=text2.length();j++){
                dp[i][j]=-1;
            }
        }
        return lcs(text1,text2,len1,len2,dp);
    }
    public int lcs(String str1,String str2,int m,int n,int dp[][]){
        if(n==0 || m==0) return 0;
        if(dp[m][n]!=-1){
            return dp[m][n];
        }else{
            if(str1.charAt(m-1) == str2.charAt(n-1)){
                dp[m][n]=lcs(str1,str2,m-1,n-1,dp)+1;
            }else{
                int ch1=lcs(str1,str2,m,n-1,dp);
                int ch2=lcs(str1,str2,m-1,n,dp);
                dp[m][n]=Math.max(ch1,ch2);
            }
            
        }
        return dp[m][n];
    }
}