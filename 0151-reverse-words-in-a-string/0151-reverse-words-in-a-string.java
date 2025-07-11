class Solution {
    public String reverseWords(String s) {
        // Trim to remove leading/trailing spaces
        s = s.trim();
        int n = s.length();
        StringBuilder ans = new StringBuilder();

        // Reverse the entire string
        StringBuilder reversed = new StringBuilder(s).reverse();

        int i = 0;
        while (i < n) {
            // If it's a space, skip it
            if (reversed.charAt(i) == ' ') {
                i++;
                continue;
            }

            StringBuilder word = new StringBuilder();

            // Build word until we hit a space or end
            while (i < n && reversed.charAt(i) != ' ') {
                word.append(reversed.charAt(i));
                i++;
            }

            // Reverse the current word to correct its order
            word.reverse();

            // Append the word to the final answer with space
            ans.append(word).append(" ");
        }

        // Remove the last extra space
        return ans.toString().trim();
    }
}