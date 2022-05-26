class Node{
    private int u;
    private int v;
    private int w;
     Node (int u, int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }
    int getU(){return u;}
  int getV(){return v;}
  int getW(){return w;}
}
class sortComparator implements Comparator<Node>{
    @Override 
    public int compare(Node a,Node b){
       if(a.getW()<b.getW())
           return -1;
        else if(b.getW()<a.getW())
          return 1;
        else return 0;  
    }
}
class Solution{
public static int findPar(int x,int[] parent){
    if(x==parent[x]) return x;
    return findPar(parent[x],parent);
}
public static void union(int u,int v,int[] parent,int[] rank){
    u=findPar(u,parent);
    v=findPar(v,parent);
    if(rank[u]>rank[v])
       parent[u]=v;
    else if(rank[v]>rank[u])
       parent[v]=u;
    else {
        parent[v]=u;
        rank[u]++;
    }   
}
static int kruskalAlgo(ArrayList<ArrayList<ArrayList<Integer>>> adj,int V){
    
    int[] parent=new int[V];
    int[] rank=new int[V];
    
    for(int i=0;i<V;i++){
        parent[i]=i;
        rank[i]=0;
    }
    ArrayList<Node> lst=new ArrayList<Node>();
    
    for(int i=0;i<V;i++){
        int len=adj.get(i).size();
        for(int j=0;j<len;j++){
             lst.add(new Node(i,adj.get(i).get(j).get(0),adj.get(i).get(j).get(1) ));
        }
       
    }
    Collections.sort(lst,new sortComparator());
    int costMax=0;
    for(Node a: lst){
        int v1=a.getU();
        int v2 =a.getV();
        int w1=a.getW();
        if(findPar(v1,parent)!=findPar(v2,parent)){
            costMax+=w1;
            union(v1,v2,parent,rank);
        }
    }
    
    return costMax;
}
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
     int res=kruskalAlgo(adj,V);
       return res;
    }
}
