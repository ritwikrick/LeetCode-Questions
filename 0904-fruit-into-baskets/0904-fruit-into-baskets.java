class Solution {
    public int totalFruit(int[] fruits) {

        // HashMap<Integer,Integer> map=new HashMap<>();
        // int n=fruits.length;
        // if(n==0) return 0;
        // int maxlen=0;
        // int left=0;
        // for(int right=0;right<n;right++){
        //     map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
        //     if(map.size()>2){
        //         int l=fruits[left];
        //         left++;
        //         map.put(l,map.get(l)-1);
        //         if(map.get(l)==0) map.remove(l);
        //     }
        //     if(map.size()<=2){
        //         maxlen= Math.max(maxlen,right-left+1);
        //     }
        // }
        // return maxlen;
        int left=0;
        int maxlen=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int right=0;right<fruits.length;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);

            if(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left])==0) map.remove(fruits[left]);
                //Because a fruit type with count 0 is no longer in the window, and
//              👉 map.size() must reflect the number of distinct fruits in the         current           window.//
                left++;
            }
            if(map.size()<=2){
                maxlen=Math.max(maxlen,right-left+1);
            }

        }
        return maxlen;

    }
}