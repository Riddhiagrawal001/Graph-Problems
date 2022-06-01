class Solution
{
    //Function to return a list of lists of integers denoting the members 
    //of strongly connected components in the given graph. 
   
    static int timer=1;
    void dfs(ArrayList<ArrayList<Integer>> adj, boolean visited[], boolean recSt[], int low[], int disc[],
            Stack<Integer> st, ArrayList<ArrayList<Integer>> res, int u) {

        visited[u] = true;
        recSt[u] = true;
        disc[u] = timer;
        low[u] = timer;
        timer++;
        st.push(u);
        for (int v : adj.get(u)){
            if (recSt[v])
                low[u] = Math.min(low[u], disc[v]);
            else if (!visited[v]){
                dfs(adj, visited, recSt, low, disc, st, res, v);
                low[u] = Math.min(low[u], low[v]);
            }
        }
        if (low[u] == disc[u]) {
            ArrayList<Integer> subres = new ArrayList<Integer>();
            while (true) {
                int v = st.pop();
                subres.add(v);
                recSt[v] = false;
                if (low[v] == disc[v])
                    break;
            }
            Collections.sort(subres);
            res.add(subres);
        }
    }

    
    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj) 
    {

      boolean visited[] = new boolean[V];
        boolean recSt[] = new boolean[V];
        int low[] = new int[V];
        int disc[] = new int[V];
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(adj, visited, recSt, low, disc, st, res, i);
        }
        Collections.sort(res, (a, b) -> a.get(0) - b.get(0));
        return res;
    }
}
