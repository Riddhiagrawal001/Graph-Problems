/* The idea is to use bfs algorithm with not iterating through adjacent nodes rather than iterating 
through all the places the knight can move . 
There will be 8 places where knight can move being (i,j): [(i-2,j-1),(i-2,j+1),(i-1,j+2),(i+1,j+2),(i+2,j+1),(i+2,j-1),(i+1,j-2),(i-1,j-2)]
*/
class Node{
    int x;
    int y;
    
    Node(int u,int v){
        this.x=u;
        this.y=v;
    }
    
    int getX(){ return x;}
    int getY(){return y;}
}
class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        int kpx=KnightPos[0];
        int kpy=KnightPos[1];
        int fx=TargetPos[0];
        int fy=TargetPos[1];
        int n=N;
        int[][] a=new int[n][n];
        
        if(kpx==fx && kpy==fy) return 0;
        
        for(int[] r : a)
           Arrays.fill(r,0);
        Queue<Node> q=new LinkedList<>();
        
        q.add(new Node(kpx-1,kpy-1) );
        while(!q.isEmpty()){
            Node nde=q.poll();
            int cx=nde.getX();
            int cy=nde.getY();
            
            if((cx+1)>=0 && (cx+1)<n && (cy+2)>=0 && (cy+2)<n && a[cx+1][cy+2]==0){
                a[cx+1][cy+2]=a[cx][cy]+1;
                q.add(new Node(cx+1,cy+2));
            }
            if((cx+2)>=0 && (cx+2)<n && (cy+1)>=0 && (cy+1)<n && a[cx+2][cy+1]==0){
                a[cx+2][cy+1]=a[cx][cy]+1;
                q.add(new Node(cx+2,cy+1));
            }
            if((cx+2)>=0 && (cx+2)<n && (cy-1)>=0 && (cy-1)<n && a[cx+2][cy-1]==0){
                a[cx+2][cy-1]=a[cx][cy]+1;
                q.add(new Node(cx+2,cy-1));
            }
            if((cx+1)>=0 && (cx+1)<n && (cy-2)>=0 && (cy-2)<n && a[cx+1][cy-2]==0){
                a[cx+1][cy-2]=a[cx][cy]+1;
                q.add(new Node(cx+1,cy-2));
            }
            if((cx-1)>=0 && (cx-1)<n && (cy-2)>=0 && (cy-2)<n && a[cx-1][cy-2]==0){
                a[cx-1][cy-2]=a[cx][cy]+1;
                q.add(new Node(cx-1,cy-2));
            }
            if((cx-2)>=0 && (cx-2)<n && (cy-1)>=0 && (cy-1)<n && a[cx-2][cy-1]==0){
                a[cx-2][cy-1]=a[cx][cy]+1;
                q.add(new Node(cx-2,cy-1));
            }
            if((cx-2)>=0 && (cx-2)<n && (cy+1)>=0 && (cy+1)<n && a[cx-2][cy+1]==0){
                a[cx-2][cy+1]=a[cx][cy]+1;
                q.add(new Node(cx-2,cy+1));
            }
            if((cx-1)>=0 && (cx-1)<n && (cy+2)>=0 && (cy+2)<n && a[cx-1][cy+2]==0){
                a[cx-1][cy+2]=a[cx][cy]+1;
                q.add(new Node(cx-1,cy+2));
            }
            
        }
       return a[fx-1][fy-1]; 
    }
}
