//내가 푼 방식
//Brute Force - O(N^2)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }
}

// Solution2
// Two-pass Hash Table
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int complements = target - nums[i];
            if(numMap.containsKey(complements) && numMap.get(complements) != i) {
                return new int[]{i, numMap.get(complements)};
            }
        }
        return new int[]{};
    }
}

// Solution3
// One-pass Hash Table
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            int complements = target - nums[i];
            if(numMap.containsKey(complements)) {
                return new int[]{numMap.get(complements), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{};
    }
}

//내가 푼 코드와 시간복잡도, 공간복잡도는 같지만, 푸는 방식이 다른 것
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 1; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                if(nums[j] + nums[j - i] == target){
                    return new int[]{j - i, j};
                }
            }
        }
        return new int[]{-1,1};
    }
}
