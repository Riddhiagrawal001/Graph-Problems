// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
class Pair{
    int val;
    int weight;
     public Pair(int val,int weight){
        this.val=val;
        this.weight=weight;
    }
}
class HelloWorld {
    static void minDistDFS( ArrayList<ArrayList<Pair>> adj,int[] dist,Stack stack){
        dist[0]=0;
        while(!stack.empty()){

            Pair node=(Pair) stack.pop();

            if(dist[node.val]!=Integer.MAX_VALUE){
                for(Pair p:adj.get(node.val)){
                    if(dist[node.val]+p.weight < dist[p.val])
                      dist[p.val]=dist[node.val]+p.weight;
                }
            }
        }
        
    }
    static void dfs(int index, ArrayList<ArrayList<Pair>>  adj,boolean[] vis,Stack stack,int weight){
        vis[index]=true;
        for(Pair i : adj.get(index)){ 
            if(!vis[i.val]){
                dfs(i.val,adj,vis,stack,i.weight);
            }
        }
        stack.push(new Pair(index,weight));
    }
    //Function to return list containing vertices in Topological order. 
    static void topoSort(int V,  ArrayList<ArrayList<Pair>>  adj,Stack stack ) 
    {
        // add your code here
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i])
              dfs(i,adj,vis,stack,0);
        }
    }
    public static void main(String[] args) {
        int V=6;
        int src=0;
        ArrayList<ArrayList<Pair>> adj=new  ArrayList<ArrayList<Pair>>();
         Stack stack = new Stack<Integer>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Pair>());
        }
        int[] vis=new int[V];
        int[] dist=new int[V];
        Arrays.fill(vis,0);
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        adj.get(0).add(new Pair(1,2));
        adj.get(0).add(new Pair(4,1));
        
        adj.get(1).add(new Pair(2,3));
        
        adj.get(2).add(new Pair(3,6));

        adj.get(4).add(new Pair(2,2));
         adj.get(4).add(new Pair(5,4));
         
         adj.get(5).add(new Pair(3,1));
         
         topoSort(V,adj,stack);
         minDistDFS(adj,dist,stack);
         
         for(int i=0;i<V;i++){
          System.out.println(dist[i]);
         }
         
    }
}
