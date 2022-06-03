class Solution {
    static void dfs(int i,int j , int oldColor,int newColor,boolean[][] vis, int n , int m,int[][] image){
        if(i<0 || j<0 || i>=n || j>=m) return ;
        if(vis[i][j]==true || image[i][j]!=oldColor) return ;
        
        vis[i][j]=true;
        image[i][j]=newColor;
        
        // top
        dfs(i-1,j,oldColor,newColor,vis,n,m,image);
        // bottom
        dfs(i+1,j,oldColor,newColor,vis,n,m,image);
        // left
        dfs(i,j-1,oldColor,newColor,vis,n,m,image);
        //right
        dfs(i,j+1,oldColor,newColor,vis,n,m,image);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n=image.length;
        int m=image[0].length;
    
        boolean[][] visited=new boolean[n][m];
        for(boolean[] r: visited)
              Arrays.fill(r,false);
        int oldColor=image[sr][sc];
        dfs(sr,sc,oldColor,newColor,visited,n,m,image);
        return image;
    }
}
