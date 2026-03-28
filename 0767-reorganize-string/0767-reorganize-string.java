class Pair {
    char ch;
    int freq;

    Pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution {
    public String reorganizeString(String s) {

        // Step 1: frequency map
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: max heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.freq - a.freq
        );

        for(char key : map.keySet()){
            pq.add(new Pair(key, map.get(key)));
        }

        StringBuilder sb = new StringBuilder();

        Pair prev = null;

        while(!pq.isEmpty()){

            Pair curr = pq.remove();
            sb.append(curr.ch);

            curr.freq--;

            // add previous back if still available
            if(prev != null && prev.freq > 0){
                pq.add(prev);
            }

            prev = curr;
        }

        // if result length != original → not possible
        if(sb.length() != s.length()){
            return "";
        }

        return sb.toString();
    }
}