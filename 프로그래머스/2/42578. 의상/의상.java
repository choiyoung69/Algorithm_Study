import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < clothes.length; i++){
            if(map.containsKey(clothes[i][1])){
                int count = map.get(clothes[i][1]);
                map.put(clothes[i][1], ++count);
            }
            else{
                map.put(clothes[i][1], 1);
            }
        }
        for(Map.Entry<String, Integer> e : map.entrySet()){
            System.out.println(e.getValue());
            answer *= (e.getValue()+1);
        }
        answer -= 1;
        
        return answer;
    }
}