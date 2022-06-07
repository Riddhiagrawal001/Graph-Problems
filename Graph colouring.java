// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int V=5;
        ArrayList<ArrayList<Integer>> adj=new  ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        adj.get(0).add(1);
        adj.get(0).add(2);
        
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(1).add(0);
        
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(2).add(4);
        
        adj.get(3).add(1);
        adj.get(3).add(2);
        
        adj.get(4).add(1);
        adj.get(4).add(2);
        System.out.println(adj);
        int[] res=new int[V];
        boolean vis[]=new boolean[V];
        Arrays.fill(res,-1);
        Arrays.fill(vis,false);
        res[0]=0;
        
        int ct=0;
        for(int i=1;i<V;i++){
            for(Integer n: adj.get(i)){
                if(res[n]!=-1)
                   vis[res[n]]=true;
            }
            int avClr;
            for(avClr=0;avClr<V;avClr++){
                if(vis[avClr]==false) break;
            }
            
            res[i]=avClr;
            ct=Math.max(ct,avClr+1);
            
            for(Integer x : adj.get(i)){
                if(res[x]!=-1)
                  vis[res[x]]=false;
            }
            
            
        }
        
        for(int i=0;i<V;i++)
              System.out.print(res[i]+" ");
        System.out.println("count of colours: "+ct);      
         
         
    }
}
