class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String longest = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String subStr = s.substring(i, j + 1);
                if (isValid(subStr) && subStr.length() > longest.length()) {
                    longest = subStr;
                }
            }
        }
        return longest;
    }

    public static boolean isValid(String str){
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}