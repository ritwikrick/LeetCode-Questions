class Solution {
    public String removeDuplicateLetters(String s) {
        int freq[]=new int[26];
        boolean seen[]=new boolean[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        Stack<Character> st=new Stack<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            freq[c-'a']--;

            if(seen[c-'a']){
                continue;
            }

            while(!st.isEmpty() && st.peek()>c && freq[st.peek()-'a']>0){
                char remove=st.pop();
                seen[remove-'a']=false;
            }
            st.push(c);
            seen[c-'a']=true;
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<st.size();i++){
            sb.append(st.get(i));
        }

        return sb.toString();
    }
}