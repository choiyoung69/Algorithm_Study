import java.util.Arrays;

class Solution {
    private int getCnt(int[] rocks, int distance, long mid) {
        int before = 0;
        int remove = 0;
        int end = distance;
        
        for(int i = 0; i < rocks.length; i++) {
            if(rocks[i] - before < mid){
                remove++;
                continue;
            }
            before = rocks[i];
        }
        
        if(end - before < mid) {
            remove++;
        }
        
        return remove;
    }
    
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
            
        long start = 0;
        long end = distance;
        
        while(start <= end) {
            long mid = (start + end) / 2;
            
            if(getCnt(rocks, distance, mid) <= n) {
                answer = (int) mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
            
        return answer;
    }
}