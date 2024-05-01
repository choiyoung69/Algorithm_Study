import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int count = score.length / m;
        
        Integer[] sc = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(sc, Collections.reverseOrder());
        
        for(int i = 0; i < count; i++){
            answer += m * sc[(i+1) * m - 1].intValue();
        }
        
        return answer;
    }
}