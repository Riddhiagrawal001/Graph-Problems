import java.util.*;
class Node{
    int u;
    int v;
    int wt;
    Node(int u , int v ,int wt){
        this.u=u;
        this.v=v;
        this.wt=wt;
    }
    int getU(){return u;}
    int getV(){return v;}
    int getWt(){return wt;}
}
class HelloWorld {
    public static void main(String[] args) {
        int N=6;
        int src=0; 
        ArrayList<Node> lst=new ArrayList<Node>();
        lst.add(new Node(3,2,6));
        lst.add(new Node(5,3,1));
        lst.add(new Node(0,1,5));
        lst.add(new Node(1,5,-3));
        lst.add(new Node(1,2,-2));
        lst.add(new Node(3,4,-2));
        lst.add(new Node(2,4,3));
        
        int[] dist=new int[N];
        Arrays.fill(dist,1000000);
        dist[src]=0;
        for(int i=1;i<=N-1;i++){
            for(Node n:lst){
                if(dist[n.getU()]+n.getWt()<dist[n.getV()])
                  dist[n.getV()]=dist[n.getU()]+n.getWt();
            }
        }
        int flag=0;
        for(Node n: lst){
            if(dist[n.getU()]+n.getWt()<dist[n.getV()]){
                flag=1;
                System.out.println("negative cycle");
                break;
            }
        }
        System.out.println("flag : "+flag);
             for(int k=0;k<N;k++)
          System.out.println("dist[k]: "+dist[k]);
    }
}
