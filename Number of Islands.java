class Solution {
    static void dfs(int i , int j , boolean[][] vis, int r , int c , char[][] grid){
       // System.out.println(cnt);
        if(i<0 || j<0 || i>=r || j>=c) return ;
        else if(grid[i][j]=='0') return ;
        
        if(!vis[i][j]){
             vis[i][j]=true;
        //top 
        dfs(i-1,j,vis,r,c,grid);
        // bottom 
        dfs(i+1,j,vis,r,c,grid);
        // left  
        dfs(i,j-1,vis,r,c,grid);
        // right
        dfs(i,j+1,vis,r,c,grid);
        }
       
        
    }
    public int numIslands(char[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        boolean[][] vis=new boolean[r][c];
        for(boolean[] x: vis)
            Arrays.fill(x,false);
        int cnt=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                  dfs(i,j,vis,r,c,grid); 
                  cnt++;
                }
            }
        }
       
        return cnt;
    }
}
