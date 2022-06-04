import java.util.*;
class Node{
    int first;
    int second;
    Node(int u,int v){
        this.first=u;
        this.second=v;
    }
    
}
class HelloWorld {
    static void make_graph(ArrayList<Node> tasks,ArrayList<ArrayList<Integer>> graph,int numTasks){
        
        for(int i=0;i<numTasks;i++)
          graph.add(new ArrayList<Integer>());
          
        for (Node n : tasks) {
            graph.get(n.second).add(n.first);
        } 
    }
    static boolean checkCycle(int i ,boolean[] vis,int[] dfsVis, ArrayList<ArrayList<Integer>> graph){
        if(!vis[i]){
            vis[i]=true;
            dfsVis[i]=1;
        }
        
        for(Integer x : graph.get(i)){
            if(dfsVis[x]==1) return true;
            if(!vis[x]){
                if(checkCycle(x,vis,dfsVis,graph)) return true;
                dfsVis[x]=0;
            }
        }
        dfsVis[i]=0;
        return false;
    }
    static boolean isPossible (ArrayList<ArrayList<Integer>> graph , int numTasks){
         boolean[] vis=new boolean[numTasks];
         int[] dfsVis=new int[numTasks];
         Arrays.fill(vis,false);
         Arrays.fill(dfsVis,0);
         
         for(int i=0;i<numTasks;i++){
             if(!vis[i]){
            // check cycle will return if there is a cycle present or not     
               boolean ans=checkCycle(i,vis,dfsVis,graph);
               //this condition means if there is no cycle then 
               // the all the tasks can be perfomed
               if(ans== false ) return true;
             }
         }
         return false;
    }
    public static void main(String[] args) {
        int numTasks=4;
        ArrayList<Node> tasks=new ArrayList<>();
        tasks.add(new Node(1,0));
         tasks.add(new Node(2,1));
          tasks.add(new Node(3,2));
        
        ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
        make_graph(tasks,graph,numTasks);
        boolean val=isPossible(graph,numTasks);
        System.out.println(tasks);
        System.out.println(graph);
        System.out.println(val);
    }
}
