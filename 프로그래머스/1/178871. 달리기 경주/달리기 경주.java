import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        List<String> strs = new ArrayList<String>(Arrays.asList(players));
        Map<String, Integer> hash = new HashMap<String, Integer>();
        for(int i = 0; i < players.length; i++){
            hash.put(players[i], i);
        }
        
        for(String s : callings){
            int i = hash.get(s);
            hash.put(s, i - 1);
            hash.put(strs.get(i - 1), i);
            Collections.swap(strs, i, i - 1);
        }
        answer = strs.stream().toArray(String[]::new);
        return answer;
    }
}