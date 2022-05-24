import java.util.*;
class HelloWorld {
    static void minDistBFS( int V, ArrayList<ArrayList<Integer>> adj, int src,int[] dist  ){
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        dist[src]=0;
        
        while(!q.isEmpty()){
            int node=q.poll();
            
            for(int i : adj.get(node)){
              
                if(dist[node]+1<dist[i]){
                    dist[i]=dist[node]+1;
                    q.add(i);
                }
            }
        }
    }
    public static void main(String[] args) {
        int V=9;
        int src=0;
        ArrayList<ArrayList<Integer>> adj=new  ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        adj.get(0).add(1);
        adj.get(0).add(3);
        
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);
        
        adj.get(2).add(1);
        adj.get(2).add(6);
        
        adj.get(3).add(0);
        adj.get(3).add(4);
        
        adj.get(4).add(3);
         adj.get(4).add(5);
         
         adj.get(5).add(4);
         adj.get(5).add(6);
         
         adj.get(6).add(2);
         adj.get(6).add(5);
         adj.get(6).add(7);
         adj.get(6).add(8);
         
         adj.get(7).add(6);
         adj.get(7).add(8);
         
         adj.get(8).add(6);
         adj.get(8).add(7);
         
         minDistBFS(V,adj,src,dist);
         
         for(int i=0;i<V;i++)
           System.out.println(dist[i]);
         
    }
}
