// Prim's Algo 
// Brute force Approach 
class Solution
{   static int primsAlgo(ArrayList<ArrayList<ArrayList<Integer>>> adj,int V){
    int[] key=new int[V];
    int[] parent=new int[V];
    boolean[] mst=new boolean[V];
    
    // for initiliazation 
    for(int i=0;i<V;i++){
        key[i]=Integer.MAX_VALUE;
        parent[i]=-1;
        mst[i]=false;
    }
    
    key[0]=0;
    
    for(int i=0;i<V-1;i++){
        int mini=Integer.MAX_VALUE;
        int node=0;
        // for finding the minimum value in the key which
        // is not part of the mst
        for(int j=0;j<V;j++){
            if(mst[j]==false && key[j]<mini){
                mini=key[j];
                node=j;
            }
        }
        
        mst[node]=true;
      
      // finding all the adjacent nodes of the current node
        ArrayList<ArrayList<Integer>> fetch = adj.get(node);
        for(ArrayList<Integer> n:fetch){
           // System.out.println(n);
            int val=n.get(0);
            int wt=n.get(1);
            if(mst[val] == false && wt<key[val]){
                parent[val]=node;
                key[val]=wt;
            }
                
        }
    }
    // the key array will contain the minimum values to reach every node
    // therefore to finding the cost of minimum spanning tree 
    // sum the whole array 
      int sum=0;
    for(int i=1;i<V;i++)
    sum+=key[i];
    
    return sum;
    
}
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
       int res= primsAlgo(adj,V);
       return res;
    }
}

// Prim's algo 
// Efficient Approach
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
{   static int primsAlgo(ArrayList<ArrayList<ArrayList<Integer>>> adj,int V){
    int[] key=new int[V];
    int[] parent=new int[V];
    boolean[] mst=new boolean[V];
    
    // for initiliazation 
    for(int i=0;i<V;i++){
        key[i]=10000000;
        parent[i]=-1;
        mst[i]=false;
    }
    PriorityQueue<Node> p = new  PriorityQueue<Node>(V, new Node());
    key[0]=0;
    p.add(new Node(0,key[0]));
    
    while(!p.isEmpty()){
        Node x  =p.peek();
        int node=x.getNode();
        p.poll();
    
        mst[node]=true;
      
      // finding all the adjacent nodes of the current node
        ArrayList<ArrayList<Integer>> fetch = adj.get(node);
        for(ArrayList<Integer> n:fetch){
           // System.out.println(n);
            int val=n.get(0);
            int wt=n.get(1);
            if(!mst[val] && wt<key[val]){
                parent[val]=node;
                key[val]=wt;
                p.add(new Node(val,wt));
            }
                
        }
    }
    // the key array will contain the minimum values to reach every node
    // therefore to finding the cost of minimum spanning tree 
    // sum the whole array 
      int sum=0;
     
    for(int k:key)
    sum+=k;
    
    return sum;
    
}
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
       int res= primsAlgo(adj,V);
       return res;
    }
}
