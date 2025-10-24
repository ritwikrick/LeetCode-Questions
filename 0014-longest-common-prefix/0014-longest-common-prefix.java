class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null){
            return "";
        }
        Arrays.sort(strs);
        StringBuilder sb=new StringBuilder();
        
        char[] first=strs[0].toCharArray();
        char[] last=strs[strs.length-1].toCharArray();
        int minlen=Math.min(first.length,last.length);
        for(int i=0;i<minlen;i++){
            if(first[i]!=last[i]){
                break;
            }sb.append(first[i]);
        }
        return sb.toString();
    }
}