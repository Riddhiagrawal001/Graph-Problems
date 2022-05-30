class Solution
{
    static void floyd_warshall(int[][] matrix){
        int v=matrix.length;
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                for(int k=0;k<v;k++){
                    if(j==i || k==i|| matrix[j][i]==-1 || matrix[i][k]==-1) continue;
                    else if(matrix[j][k]==-1) matrix[j][k]=Integer.MAX_VALUE;
                      matrix[j][k]=Math.min(matrix[j][k],(matrix[j][i]+matrix[i][k]));
                 }
            }
        }
    }
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        floyd_warshall(matrix);
    }
}
