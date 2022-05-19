class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs=new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis=new boolean[V+1];
        
        q.add(0);
        vis[0]=true;

                while(!q.isEmpty()){
                    Integer curr=q.poll();
                    bfs.add(curr);
                    for(Integer a:adj.get(curr)){
                        if(vis[a]==false){
                            vis[a]=true;
                            q.add(a);
                        }
                    }
                }
        
        

        return bfs;
    }
}
