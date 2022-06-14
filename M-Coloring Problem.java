class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    boolean safeState(int node , int[] clr, boolean[][] graph, int i){
        for(int j=0;j<graph.length;j++){
            if(graph[node][j]){
                if(clr[j]==i) return false;
            }
        }
        return true;
    }
    boolean graphColour(int index, int[] clr, boolean[][] graph , int m , int n){
        if(index== n ) return true;
        
        for(int i=1;i<=m;i++){
            if(safeState(index,clr,graph,i)){
                clr[index]=i;
                if(graphColour(index+1,clr,graph,m,n)) return true;
                clr[index]=0;
            }
        }
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        
       int[] clr=new int[n];
       return graphColour(0,clr,graph,m,n);
    }
}
