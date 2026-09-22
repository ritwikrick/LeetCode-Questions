class Solution {
    public String reverseWords(String s) {
        String arr[] = s.trim().split("\\s+");
        String narr[]=new String[arr.length];
        int j=0;
        for(int i=arr.length-1;i>=0;i--){
            narr[j]=arr[i];
            j++;
        }
        String ans="";
        for(int i=0;i<narr.length;i++){
            ans+=narr[i] + " ";
        }
        return ans.trim();
    }
}