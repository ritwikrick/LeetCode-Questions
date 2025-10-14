class Solution {
    public boolean isPalindrome(String s) {
        String clean=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int right=clean.length()-1;
        char ch[]=clean.toCharArray();
        int left=0;
        
        while(left<right){
            if(ch[left]==ch[right]){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}