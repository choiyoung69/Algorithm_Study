import java.util.*;

class Solution {
    
    private void count(int index, Set<String> now, 
                    String[][] bans, Set<Set<String>> banSet) {
        if(index == bans.length) {
            banSet.add(new HashSet<>(now)) ;
            return;
        }
        
        for(String id : bans[index]) {
            if(now.contains(id)) continue;
            
            now.add(id);
            count(index + 1, now, bans, banSet);
            now.remove(id);
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        
       String[][] bans = Arrays.stream(banned_id)
           .map(banned -> banned.replace('*', '.'))
           .map(banned -> Arrays.stream(user_id)
                            .filter(id -> id.matches(banned))
                            .toArray(String[]::new))
           .toArray(String[][]::new);
        
        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);
        return banSet.size();
    }
}