class Solution {
    public static int minimumTime(int n,int m, int[][] edges) {
        // code here
        int[] indegree =new int[n+1];
         ArrayList<Integer> adj[]=new ArrayList[n];
        for(int i=0;i<n;i++)
            adj[i]=new ArrayList<Integer>();
            
            
        Arrays.fill(indegree,0);
        for(int i=0;i<m;i++){
            int y=edges[i][1];
            int x=edges[i][0];
            adj[x-1].add(y);
            indegree[y]++;
            
        }
        int[] time=new int[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0){
                  q.add(i);
                  time[i-1]=1;
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            for(Integer x : adj[node-1]){
                indegree[x]--;
                if(indegree[x]==0){
                    time[x-1]=time[node-1]+1;
                    q.add(x);
                }
            }
        }
    return time;
    }
}
       
        
