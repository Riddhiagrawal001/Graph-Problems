class Node implements Comparator<Node>{
    private int dist;
    private int node;
    Node (int n, int d){
        this.dist=d;
        this.node=n;
    }
    Node() {};
    int getDist(){return dist;}
    int getNode(){return node;}
    
    @Override 
    public int compare(Node n1, Node n2){
        if(n1.dist<n2.dist)
           return -1;
        if(n1.dist>n2.dist)
          return 1;
        return 0;  
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertice
    //from the source vertex S.
    static void dijkstraBFS(int s,ArrayList<ArrayList<ArrayList<Integer>>> adj,int V,int[] dist ){
        dist[s]=0;
         PriorityQueue<Node> p = new  PriorityQueue<Node>(V, new Node());
         p.add(new Node(s,0));
         while(p.size()>0){
             Node n=p.remove();
             int x=n.getNode();
              ArrayList<ArrayList<Integer>> fetch = adj.get(x);
             for(ArrayList<Integer> i:fetch){
                  int dis=i.get(1);
                 int nod=i.get(0);
                 if(dist[x]+dis< dist[nod]){
                    dist[nod]=dist[x]+dis;
                    p.add(new Node(nod, dist[nod]));
                 }
             }
         }
        
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dijkstraBFS(S,adj,V,dist);
        return dist;
        
    }
}

