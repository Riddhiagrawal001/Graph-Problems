class Solution {
    static void dfs(Node[] vis, Node copy , Node node){
        vis[copy.val]=copy;
        for(Node x : node.neighbors){
            if(vis[x.val]==null){
                Node temp=new Node(x.val);
                copy.neighbors.add(temp);
                dfs(vis,temp,x);
            }
            else{ 
              copy.neighbors.add(vis[x.val]);  
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node==null) 
            return null;
        
        Node copy=new Node(node.val);
        Node[] vis=new Node[101];
        Arrays.fill(vis,null);
        
        dfs(vis,copy,node);
        return copy;
    }
}
