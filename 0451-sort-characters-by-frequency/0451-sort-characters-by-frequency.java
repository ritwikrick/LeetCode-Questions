class Pair implements Comparable<Pair>{
    char c;
    int f;
    Pair(char c,int f){
        this.c=c;
        this.f=f;
    }
    @Override
    public  int compareTo(Pair p){
        //Max-heap
        return p.f-this.f;
    }
}
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        ArrayList<Character> list=new ArrayList<>(map.keySet());
        for(int i=0;i<list.size();i++){
            char key=list.get(i);
            int val=map.get(key);
            pq.add(new Pair(key,val));
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size();i++){
            int n=pq.peek().f;
            char ch=pq.remove().c;
            for(int j=0;j<n;j++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}