//DFS
class Solution {
    static boolean checkCycleDFS(int index,ArrayList<ArrayList<Integer>> adj,int[] vis,int[] dfsVis){
       if(vis[index]==0){vis[index]=1;
        dfsVis[index]=1;}
           
       
        for(Integer x: adj.get(index)){
            if(dfsVis[x]==1) return true;
            if(vis[x]!=1){
                 if(checkCycleDFS(x,adj,vis,dfsVis)) return true;
                 dfsVis[x]=0;
            }
        }
       dfsVis[index]=0;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] vis=new int[V];
        int[] dfsVis=new int[V];
        Arrays.fill(vis,0);
        Arrays.fill(dfsVis,0);
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
            boolean ans=checkCycleDFS(i,adj,vis,dfsVis);
               if(ans) return true;
            }
            
        }
        return false;
    }
}
