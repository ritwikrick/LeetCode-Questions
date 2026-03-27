class Pair implements Comparable<Pair>{
    String word;
    int freq;
    Pair(String word, int freq){
        this.word=word;
        this.freq=freq;
    }
    @Override
    public int compareTo(Pair p){
        //Max heap
        if(p.freq!=this.freq){
            return p.freq-this.freq;
        }
        //if freq is same, then we will sort acc to lexicographically order.
        return this.word.compareTo(p.word);
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        HashMap<String, Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        ArrayList<String> list=new ArrayList<>(map.keySet());
        for(int i=0;i<list.size();i++){
            String key=list.get(i);
            int val=map.get(key);
            pq.add(new Pair(key,val));
        }
        ArrayList<String> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(pq.remove().word);
        }
        return ans;
    }
}