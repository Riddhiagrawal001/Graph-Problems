// BFS 
class Solution
{
 public static boolean bfsCheck(int index,ArrayList<ArrayList<Integer>>adj,int[] colour) {
     Queue<Integer> q=new LinkedList<>();
     q.add(index);
     colour[index]=1;
     while(!q.isEmpty()){
         Integer node=q.poll();
         
         for(Integer n : adj.get(node)){
             if(colour[n]==-1){
                 colour[n]=1-colour[node];
                 q.add(n);
             }
             else if(colour[n]==colour[node])
             return false;
         }
     }
     return true;
 }  
    public static boolean checkOddCycle(int V,ArrayList<ArrayList<Integer>>adj,int[] colour ){
        for(int i=0;i<V;i++){
            if(colour[i]==-1){
                if(!bfsCheck(i,adj,colour))
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] colour=new int[V];
	    Arrays.fill(colour,-1);
	    if(checkOddCycle(V,adj,colour)) return true;
	   return false;
    }
}

// DFS
public static boolean dfsCheck(int index,ArrayList<ArrayList<Integer>>adj,int[] colour){
     if(colour[index]==-1) colour[index]=1;
     for(Integer i: adj.get(index)){
        if(colour[i]==-1){
            colour[i]=1-colour[index];
            if(!dfsCheck(i,adj,colour)) return false;
        }
        else if(colour[i]==colour[index]) return false;
     }
     return true;
 }
    public static boolean checkOddCycle(int V,ArrayList<ArrayList<Integer>>adj,int[] colour ){
        for(int i=0;i<V;i++){
            if(colour[i]==-1){
                if(!dfsCheck(i,adj,colour))
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] colour=new int[V];
	    Arrays.fill(colour,-1);
	    if(checkOddCycle(V,adj,colour)) return true;
	   return false;
    }
}
