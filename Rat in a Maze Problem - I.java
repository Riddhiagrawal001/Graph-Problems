/* the idea is to go to everywhere form the current position and then if there is a blockage then
backtrack to the place making the visited as unvisited */

/* tc: O(n^2)^4 [because we are iterating through every position in the matrix & from every cell we are going to 4 
different directions]
sc:O (L*X) l=length of the path x=no of paths */

class Solution {
    static void dfs(int i,int j, int[][] m ,ArrayList<String> res, boolean[][] visited,String s,int n){
      // outer boundries   
      if(i<0 || j<0 || i>=n || j>=n) return;
      // if the next cell is 0 or it is visited beforehand 
        if(m[i][j]==0 || visited[i][j]==true) return;
      
      // if we reach to the destination
        if(i==n-1 && j==n-1 ) {
            res.add(s);
            return;
        }
        visited[i][j]=true;
      
      // moving to everyplace from the current cell
        //up
        dfs(i-1,j,m,res,visited,s+'U',n);
        //down
         dfs(i+1,j,m,res,visited,s+'D',n);
        //left
        dfs(i,j-1,m,res,visited,s+'L',n);
        //right
         dfs(i,j+1,m,res,visited,s+'R',n);
         
         visited[i][j]=false;
        
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> res=new ArrayList<>();
        boolean[][] visited=new boolean[n][n];
        for(boolean[] r: visited)
           Arrays.fill(r,false);
        String s="";   
        if(m[0][0]==0 || m[n-1][n-1]==0){
           s=Integer.toString(-1);
           res.add(s);
        }  
            dfs(0,0,m,res,visited,s,n);
            Collections.sort(res);
        return res;
    }
}
