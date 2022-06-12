// BFS (Time level exceeded )
class Node {
    int v;
    int w;
    Node(int v , int w){
        this.v=v;
        this.w=w;
        
    }
}
class Pair{
    int cost;
    int node;
    int stop;
    Pair(int c,int n , int s ){
        this.cost=c;
        this.node=n;
        this.stop=s;
    }
}
class costComparator implements Comparator<Pair>{
    public int compare (Pair p1, Pair p2){
        if(p1.cost<p2.cost) return -1;
        else if (p1.cost > p2.cost) return 1;
        return 0;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Node>[] adj=new ArrayList[n];
       for(int g=0;g<n;g++)
            adj[g]=new ArrayList<Node>();
        int size =flights.length;
        for(int i=0;i<size;i++){
            
            int s=flights[i][0];
            int d=flights[i][1];
            int c=flights[i][2];
            adj[s].add(new Node(d,c));
        }
        PriorityQueue<Pair> q=new PriorityQueue<Pair>(new costComparator());
        q.add(new Pair(0,src,0));
        while(!q.isEmpty()){
            Pair x=q.poll();
            if (x.node==dst ) return x.cost  ;
            if(x.stop>k) continue;
            for(Node nde : adj[x.node] ){   
               q.add(new Pair(x.cost+nde.w,nde.v,x.stop+1));
            }
        }
       
        return -1;
    }
}

// Bellmen -ford kind of algo
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] res=new int[n];
        Arrays.fill(res,Integer.MAX_VALUE);
       
        res[src]=0;
        for(int i=0;i<=k;i++){
             int[] temp=new int[n];
             System.arraycopy(res,0,temp,0,n);
            for(int[] val : flights){
                int s=val[0];
                int d=val[1];
                int p=val[2];
                if(res[s]==Integer.MAX_VALUE) continue;
                if(res[s]+p < temp[d]) temp[d]=res[s]+p;
            }
            res=temp;
        }
        return res[dst]==Integer.MAX_VALUE? -1 : res[dst];
    }
}
