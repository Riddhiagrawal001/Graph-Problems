class Solution {
    public static void dfs(int curr,ArrayList<ArrayList<Integer>> adj,boolean[] vis, ArrayList<Integer> dfs){
        dfs.add(curr);
        vis[curr]=true;
        
        for(Integer i : adj.get(curr)){
           if(!vis[i])
             dfs(i,adj,vis,dfs);
        }
        
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs=new  ArrayList<>();
        boolean[] vis =new boolean[V+1];
        
        dfs(0,adj,vis,dfs);
        return dfs;
        // Code here
    }
}
