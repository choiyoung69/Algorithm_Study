import java.util.HashMap;

class Solution {  
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i : nums){
            if(map.containsKey(i)){
                int count = map.get(i);
                map.put(i, ++count);
            } 
            else map.put(i, 1);
        }
        
        if(map.size() > nums.length/2) return nums.length/2;
        else return map.size();
    }
}