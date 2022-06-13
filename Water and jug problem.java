class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity+jug2Capacity < targetCapacity) return false;
        
        int[] possible={jug1Capacity,-jug1Capacity , jug2Capacity, -jug2Capacity};
        HashMap<Integer,Integer> vis=new HashMap<>();
        Queue<Integer> q=new LinkedList();
        q.add(0);
        vis.put(0,1);
        while(!q.isEmpty()){
            int a = q.poll();
            if(a==targetCapacity) return true;
            
            for(int val:possible){
                int temp= a+val;
                if(temp==targetCapacity) return true;
                if(temp<0 || temp > (jug1Capacity+jug2Capacity) ) continue;
                if(!vis.containsKey(temp)){
                    q.add(temp);
                    vis.put(temp,1);
                }
            }
        }
        return false; 
    }
}
