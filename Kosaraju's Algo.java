class Solution
{   
    static void topoSort(int i,boolean[] vis, Stack<Integer> s,ArrayList<ArrayList<Integer>> adj){
        vis[i]=true;
        for(Integer node: adj.get(i)){
            if(!vis[node])
              topoSort(node,vis,s,adj);
        }
       s.push(i);
    }
    static void revDfs(int node,ArrayList<ArrayList<Integer>> transpose,boolean[] vis){
        vis[node]=true;
        
        for(Integer i: transpose.get(node)){
            if(!vis[i])
              revDfs(i,transpose,vis);
        }
    }
    static int countSCC(int V, ArrayList<ArrayList<Integer>> adj){
    // step 1 : make a topological way stack
    boolean[] vis=new boolean[V];
    Arrays.fill(vis,false);
    Stack<Integer> s=new Stack<Integer>();
    
    for(int i=0;i<V;i++){
      if(!vis[i])  
         topoSort(i,vis,s,adj);
    }
    
    // step 2: Transpose the graph 
     Arrays.fill(vis,false);
     ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();
     for(int i=0;i<V;i++)
       transpose.add(new ArrayList<Integer>());
       
    for(int j=0;j<V;j++){
        for(Integer x: adj.get(j))
           transpose.get(x).add(j);
    }  
    
    // do the dfs according to the topoSort stack
    int count=0;
    while(!s.empty()){
        int x=s.pop();
        if(!vis[x]){
          revDfs(x,transpose,vis);
          count++;
        }
    }
    
    
    return count;
    
}
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        int res=countSCC(V,adj);
        return res;
        
    }
}
