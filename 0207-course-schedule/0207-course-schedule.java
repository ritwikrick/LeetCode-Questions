class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            adj.get(prereq).add(course); // directed edge: prereq → course
        }
        //logic
        boolean vis[]=new boolean[numCourses];
        boolean s[]=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(cycle(i,adj,vis,s)) return false;
        }
        return true;
    }
    public boolean cycle(int curr,ArrayList<ArrayList<Integer>> adj,boolean vis[],      boolean s[]){
        vis[curr]=true;
        s[curr]=true;
        for(int i=0;i<adj.get(curr).size();i++){
            int neibh=adj.get(curr).get(i);
            if(!vis[neibh]){
                if(cycle(neibh,adj,vis,s)) return true;
            }else if(s[neibh]) return true;
        }
        s[curr]=false;
        return false;
    }
}