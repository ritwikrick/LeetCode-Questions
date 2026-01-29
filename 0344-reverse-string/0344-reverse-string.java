class Solution {
    public void reverseString(char[] s) {
       int left=0;
       int right=s.length-1;
       while(left<right){
            rev(left,right,s);
            left++;
            right--;
       }
    }
    public void rev(int left,int right,char []s){
        char temp=' ';
        temp=s[left];
        s[left]=s[right];
        s[right]=temp;
    }
}