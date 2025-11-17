class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int c=0;
        for(int i=0;i<n;i++){
            String check="";
           for(int j=i;j<n;j++){
                char ch=s.charAt(j);
                check+=ch;
                if(Pale(check)){
                    c++;
                }
           }
            
        }
        return c;
    }
    public static boolean Pale(String ss){
        char temp;
        int i=0,j=ss.length()-1;
        while(i<j){
            if(ss.charAt(i)!=ss.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}