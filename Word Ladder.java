class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        if(!wordList.contains(endWord)) return 0;
        int len=0;
        while(!q.isEmpty()){
           
            len++;
            int currQueueLen=q.size();
            
            for(int i=0;i<currQueueLen;i++){
                String temp=q.poll();
                for(int j=0;j<temp.length();j++){
                    char x=temp.charAt(j);
                    for(char c='a';c<='z';c++){
                        temp=temp.substring(0,j)+c+temp.substring(j+1);
                       
                        if(endWord.equals(temp)){ 
                            return len+1 ;
                                                 }
                        else if(wordList.contains(temp)==false) continue;
                        
                        wordList.remove(temp);
                        q.add(temp);
                    }
                    temp=temp.substring(0,j)+x+temp.substring(j+1);
                }
            }
        }
        return 0;
    }
}
