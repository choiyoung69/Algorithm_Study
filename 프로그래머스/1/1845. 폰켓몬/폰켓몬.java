import java.util.HashMap;

class Solution {  
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer, Integer> typeHash = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            typeHash.put(nums[i],  0);
        }
        
        answer = typeHash.size();
        if(answer >= nums.length/2){
            answer = nums.length/2;
        }
        return answer;
    }
}