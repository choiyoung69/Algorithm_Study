import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> days = new LinkedList<>();
        Vector<Integer> func = new Vector<Integer>();
        
        for(int i = 0; i < progresses.length; i++){
            if((100 - progresses[i]) % speeds[i] == 0){
                days.add((100 - progresses[i]) / speeds[i]);
            } 
            else{
                days.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }
        while(!days.isEmpty()){
            int day = days.peek();
            int count = 0;
            while(!days.isEmpty() && day >= days.peek()){
                days.poll();
                count++;
            }
            func.add(count);
        }
        answer = func.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}