class Solution
{   
    static void dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> lst,boolean[] vis,int[] tin,int[] low,int timer){
    vis[node]=true;
    tin[node]=low[node]=timer++;
    int child=0;
    for(Integer i:adj.get(node)){
        if(i==parent) continue;
        
        if(!vis[i]){
            dfs(i,node,adj,lst,vis,tin,low,timer);
            low[node]=Math.min(low[node],low[i]);
            
            if(low[i]>=tin[node] && parent!=-1) {
                lst.add(node);
            }
            child++;
        }
        else {
            low[node]=Math.min(low[node],tin[i]);
        }
    }
    if(parent==-1 && child>1 ) lst.add(node);
    
}
    static void getArticulation(int V,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> lst ){
        boolean[] vis =new boolean[V];
        int[] tin=new int[V];
        int[] low=new int[V];
        
        int timer=0;
        for(int i=0;i<V;i++){
            if(!vis[i])
               dfs(i,-1,adj,lst,vis,tin,low,timer);
        }
        
    }
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list)
    {
        Set<T> set = new LinkedHashSet<>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        return list;
    }
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ArrayList<Integer> lst=new ArrayList<Integer>();
        getArticulation(V,adj,lst);
         ArrayList<Integer> newList=new ArrayList<Integer>();
        if(lst.size()>0 ){
           Collections.sort(lst);
           newList = removeDuplicates(lst); 
        }
        else {
            newList.add(-1);
        }
        
        return newList;
        
    }
}
