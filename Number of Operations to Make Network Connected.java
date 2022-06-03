class Solution {
    static void dfs(int index, boolean[] vis,ArrayList<Integer> adj[] ){
        vis[index]=true;
        
        for(Integer x: adj[index]){
            if(!vis[x])
                dfs(x,vis,adj);
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int m =connections.length;
        if(m<n-1) return -1;
        
        ArrayList<Integer> adj[]=new ArrayList[n];
        for(int i=0;i<n;i++)
            adj[i]=new ArrayList<Integer>();
        for(int i=0;i<m;i++){
            adj[connections[i][0]].add(connections[i][1]);
           adj[connections[i][1]].add(connections[i][0]); 
        }
        boolean[] vis=new boolean[n];
        Arrays.fill(vis,false);
        
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(i,vis,adj); 
            }
               
        }
        return count-1;
        
    }
}
