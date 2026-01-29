class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=p.length();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<=s.length()-n;i++){
            String subs=s.substring(i,i+n);
            if(anagram(subs,p)){
                list.add(i);
            }
        }
        return list;
    }
    public boolean anagram(String s, String p){
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<p.length();i++){
            freq[p.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
}