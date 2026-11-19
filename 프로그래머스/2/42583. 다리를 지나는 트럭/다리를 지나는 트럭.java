import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int now_weight = 0;
        int now_time = 0;
        int now_index = 0;
        int[] enteringTime = new int[truck_weights.length];
        
        Queue<Integer> trucks = new LinkedList<>();

        for (int truck : truck_weights) {
            trucks.offer(truck);
        }
        
        while(now_index < truck_weights.length) {
            now_time++;
            
            int enteredCount = truck_weights.length - trucks.size();
            
            
            if(now_index < enteredCount && now_time - enteringTime[now_index] >= bridge_length) {
                now_weight -= truck_weights[now_index];
                now_index++;
            }
            
            if(!trucks.isEmpty() && now_weight + trucks.peek() <= weight) {
                enteringTime[enteredCount] = now_time;
                now_weight += trucks.poll();
            }
            
        }
        
        return now_time;
    }
}