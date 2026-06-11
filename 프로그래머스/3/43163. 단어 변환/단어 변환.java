import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        if(!checkTargetExists(target, words)) return 0;
        
        Queue<String> queue = new LinkedList();
        boolean[] visited = new boolean[words.length];
        queue.add(begin);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int s = 0; s < size; s++){
                String now = queue.poll();
            
                if(now.equals(target)) return answer;
            
                for(int i = 0; i < words.length; i++) {
                    if(visited[i]) continue;
                    if(!checkOneLetter(now, words[i])) continue;
                
                    visited[i] = true;
                    queue.add(words[i]);
                }   
            }
            
            answer++;
        }
    
        
        return answer;
    }
    
    
    private boolean checkTargetExists(String target, String[] words){
        boolean flag = false;
        
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(target)){
                flag = true;
                continue;
            }
        }
        if(flag) return true;
        return false;
    }
    
    private boolean checkOneLetter(String now, String word) {
        boolean flag = false;
        for(int i = 0; i < now.length(); i++){
            if(flag && now.charAt(i) != word.charAt(i)) return false;
            if(now.charAt(i) != word.charAt(i)) flag = true;
        }
        return true;
    }
}