class Solution {
    public int totalFruit(int[] fruits) {

        HashMap<Integer,Integer> map=new HashMap<>();
        int n=fruits.length;
        if(n==0) return 0;
        int maxlen=0;
        int left=0;
        for(int right=0;right<n;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            if(map.size()>2){
                int l=fruits[left];
                left++;
                map.put(l,map.get(l)-1);
                if(map.get(l)==0) map.remove(l);
            }
            if(map.size()<=2){
                maxlen= Math.max(maxlen,right-left+1);
            }
        }
        return maxlen;

    }
}