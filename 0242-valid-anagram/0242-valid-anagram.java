import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        // char[] sChars = s.toCharArray();
        // char[] tChars = t.toCharArray();
        
        // Arrays.sort(sChars);
        // Arrays.sort(tChars);
        
        // return Arrays.equals(sChars, tChars);

        //-------2ND METHOD-------
        // HashMap<Character, Integer> map1=new HashMap<>();
        // for(int i=0;i<s.length()-1;i++){
        //     map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
        // }
        //  HashMap<Character, Integer> map2=new HashMap<>();
        // for(int i=0;i<t.length()-1;i++){
        //     map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
        // }

        // return map1.equals(map2);

        //------USING 1 HASHMAP
        if(s.length()!= t.length()){
            return false;
        }
        HashMap<Character,Integer> map= new HashMap<>();
         for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
         }
        for(int i=0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i))){
                return false;
            }
             map.put(t.charAt(i),map.get(t.charAt(i))-1);

            if(map.get(t.charAt(i))<0){
                return false;
            }
         }
        
        return true;
        

    }
}