class Solution {
    public int countSubstrings(String s) {
        int c=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String subs=s.substring(i,j+1);
                if(pal(subs)){
                    c++;
                }
            }
        }
        return c;
    }
    public boolean pal(String s){
        int left=0,right=s.length()-1;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}