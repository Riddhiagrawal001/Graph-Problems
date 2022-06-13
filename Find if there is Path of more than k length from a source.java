import java.util.*;
class Node{
    int u;
    int w;
    Node(int u ,int w ){
        this.u=u;
        this.w=w;
    }
}
class HelloWorld {
    static boolean dfs(int index, int k , ArrayList<Node>[] al , boolean[] vis ){
        vis[index]=true;
        if(k<=0) return true;
        
        for(Node nde: al[index]){
            int u=nde.u;
            int w=nde.w;
            if(vis[u]==true) return true;
            if(dfs(u,k-w,al,vis)) return true;
        }
        vis[index]=false;
        return false;
    }
    public static void main(String[] args) {
        int v=10;
        int k=23;
        ArrayList<Node>[] al = new ArrayList[v];
        for(int i=0;i<v;i++){
            al[i]  = new ArrayList<Node>();
        }
        for(int i=0;i<v;i++){
            Scanner sc=new Scanner(System.in);
            int x=sc.nextInt();
            int y=sc.nextInt();
            int z=sc.nextInt();
            al[x].add(new Node(y,z));
            al[y].add(new Node(x,z));
        }
        boolean[] vis=new boolean[v];
        Arrays.fill(vis,false);
        System.out.println(dfs(1,k,al,vis));
    }
}
