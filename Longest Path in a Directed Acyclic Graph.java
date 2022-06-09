import java.util.*;
class Node {
    int v;
    int w;
    
    Node ( int v , int w){
        this.v=v;
        this.w=w;
    }
    
}
class HelloWorld {
    public static void main(String[] args) {
        int n = 6;
        int src = 1;
        ArrayList<ArrayList<Node>> adj=new ArrayList<ArrayList<Node>>();
        for(int i=0;i<n;i++)
          adj.add(new ArrayList<Node>());
        adj.get(0).add(new Node(1,5));
        
        adj.get(1).add(new Node(5,5));
        adj.get(1).add(new Node(4,2));
        
        adj.get(3).add(new Node(2,20));
        
        adj.get(4).add(new Node(2,10));
        
        adj.get(5).add(new Node(2,50));
        adj.get(5).add(new Node(3,2));
        
        Queue<Integer> q =new LinkedList();
        int[] res=new int[n];
        Arrays.fill(res,-9999);
        
        q.add(src);
        res[src]=0;
        while(!q.isEmpty()){
            int val=q.poll();
            for(Node nde : adj.get(val)){
                int vertex=nde.v;
                int weight=nde.w;
                if(res[vertex]==-9999)
                res[vertex]=res[val]+weight;
                else {
                    res[vertex]=Math.max(res[vertex],res[val]+weight);
                }
                q.add(vertex);
            }
        }
      for(int i=0;i<n;i++)
         System.out.println("res["+i+"]:"+res[i]);
    }
}
