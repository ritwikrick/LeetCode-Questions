class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        StringBuilder ans=new StringBuilder();
        StringBuilder sb=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            char c=s.charAt(i);
            if(c!=' '){
                sb.append(c);
            }else{
                ans.append(sb.reverse());
                if(sb.length()!=0){
                    ans.append(' ');
                }
                sb=new StringBuilder();
                
            }
        }
        if(sb.length()>0){
            ans.append(sb.reverse());
        }
        return ans.toString().trim();
    }
}