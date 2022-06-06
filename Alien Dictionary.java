class Solution
{
    static void dfs(int node , boolean[] vis,ArrayList<ArrayList<Integer>> graph
    ,Stack<Character> s)
    {
        vis[node]=true;
        
        for(Integer n : graph.get(node)){
          if(!vis[n])
              dfs(n,vis,graph,s);
        }
 
     s.push((char)(node+'a'));
    }
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        
        ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<K;i++)
           graph.add(new ArrayList<Integer>());
        for(int i=0;i<N-1;i++){
            String w1=dict[i];
            String w2=dict[i+1];
           
            for(int j=0;j<Math.min(w1.length(),w2.length());j++){
                char c1=w1.charAt(j);
              char c2=w2.charAt(j);
              
                if(c1!=c2){
                   
                    graph.get(c1-'a').add(c2-'a');
                    break;
                }
            
            }
            
        }
        
        boolean[] vis=new boolean[K];
        Arrays.fill(vis,false);
        Stack<Character> stack = new Stack<Character>();
       StringBuilder str= new StringBuilder();
        for(int k=0;k<K;k++){
            if(!vis[k])
              dfs(k,vis,graph,stack);
        }
       
        while(!stack.empty()){
            Character ch=stack.pop();
            str.append(ch);
        }
       
        
          
        return str.toString();
}
}
