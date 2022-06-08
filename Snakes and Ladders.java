class Solution {
    public int[] findCord(int curr, int n){
        int[] res=new int[2];
        int r=n-(curr-1) / n-1;
        int c=(curr-1)%n;
        if(r%2==n%2) {
            res[0]=r;
            res[1]=n-1-c;
        }
        else{ 
            res[0]=r;
            res[1]=c;
        }
        return res;
    }
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        boolean[][] vis=new boolean[n][n];
        for(boolean[] r : vis)
            Arrays.fill(r,false);
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        vis[n-1][0]=true;
        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int x=q.poll();
                if(x== n*n) return count;
                for(int k=1;k<=6;k++){
                    if(k+x > n*n ) break;
                    int pos[]=findCord(k+x,n);
                    int row=pos[0];
                    int col=pos[1];
                    if(!vis[row][col]){
                        vis[row][col]=true;
                        if(board[row][col]==-1)
                            q.add(k+x);
                        else 
                            q.add(board[row][col]);
                    }
                }
            }
            count++;
        }
    return -1;        
    }
}
