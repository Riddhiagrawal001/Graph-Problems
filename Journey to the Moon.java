static void dfs(int index, ArrayList<ArrayList<Integer>> graph, boolean[] vis , int count,ArrayList<Integer> countComp ){
        
        vis[index]=true;
        if(count >= countComp.size() || count < 0)
           countComp.add(count,1);
        else countComp.set(count,countComp.get(count)+1);
        for(Integer x : graph.get(index) ){
            if(!vis[x])
               dfs(x,graph, vis, count,countComp);
        } 
    }
    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
    // Write your code here
     ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
      for(int i=0;i<n;i++)
           graph.add(new ArrayList<Integer>());
       int len=astronaut.size();    
      for(int j=0;j<len;j++){
          int val1=astronaut.get(j).get(0);
          int val2=astronaut.get(j).get(1);
          graph.get(val1).add(val2);
          graph.get(val2).add(val1);
      } 
      boolean[] vis=new boolean[n];
      ArrayList<Integer> countComp=new ArrayList<Integer>();
      Arrays.fill(vis,false);
      int count=0;
      for(int k=0;k<n;k++){
          if(!vis[k]){
               dfs(k,graph,vis,count,countComp);
            count++;
          }
      }
      int n1=n-1;
      long mul=(long)n1*n;
       long totalP=(mul/2);
      for(int l=0;l<countComp.size();l++){
          int temp=countComp.get(l);
          totalP=totalP-((temp*(temp-1))/2);
      }
     return totalP;
    }

}
