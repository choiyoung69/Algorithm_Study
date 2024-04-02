import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
              
        for(String name : completion){
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for(String str: participant){
            boolean check = map.getOrDefault(str, 0) > 0;
            
            if(check) map.put(str, map.get(str) - 1);
            else{
                answer = str;
                break;
            }
        }
        return answer;
    }
}