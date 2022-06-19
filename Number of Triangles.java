class Solution {
    public static boolean isDirected(int n, int[][] g){
        int flag=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(g[i][j]!= g[j][i] && j!=i) {
                    return true;
                }
            }
        }
        return false;
    }
    public static int numberOfTriangles(int n, int[][] g) {
        boolean checkifDirected= isDirected(n,g);
        // code here
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(g[i][j]==1 && g[j][k]==1 && g[k][i]==1 && i!=j && j!=k && i!=k)
                      count++;
                }
            }
        }
        return checkifDirected?count/3:count/6;
    }
}
        
