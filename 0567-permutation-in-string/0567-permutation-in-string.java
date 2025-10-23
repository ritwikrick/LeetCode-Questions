class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c : s1.toCharArray()) map1.put(c, map1.getOrDefault(c, 0) + 1);

        int window = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);

            if (i >= window) {
                char left = s2.charAt(i - window);
                map2.put(left, map2.get(left) - 1);
                if (map2.get(left) == 0) map2.remove(left);
            }

            if (map1.equals(map2)) return true;
        }

        return false;
    }
}
