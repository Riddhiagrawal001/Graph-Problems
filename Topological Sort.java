// DFS
class Solution
{
    static void dfs(int index,ArrayList<ArrayList<Integer>> adj,boolean[] vis,Stack<Integer> stack){
        vis[index]=true;
        for(Integer i : adj.get(index)){
            if(!vis[i]){
                dfs(i,adj,vis,stack);
            }
        }
        stack.push(index);
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean[] vis=new boolean[V];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0;i<V;i++){
            if(!vis[i])
              dfs(i,adj,vis,stack);
        }
        int[] res=new int[V];
        for(int i=0;i<V;i++)
           res[i]=stack.pop();
        return res;   
    }
}

//BFS
 static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] indegree=new int[V];
        Queue<Integer> q=new LinkedList<>();
          int[] res=new int[V];
          int index=0;
         
        for(int i=0;i<V;i++){
            for(Integer x: adj.get(i))
              indegree[x]++;
        }
        
        for(int i=0;i<V;i++){
            if(indegree[i]==0)
              q.add(i);
        }
        
        while(!q.isEmpty()){
            int n=q.poll();
            res[index++]=n;
            for(Integer a: adj.get(n)){
                indegree[a]--;
                if(indegree[a]==0)
                  q.add(a);
            }
        }
        
        return res;
    }
