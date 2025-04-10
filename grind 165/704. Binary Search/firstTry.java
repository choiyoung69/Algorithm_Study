//이분 검색으로 풀었음
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int divide = (right - left)/2 + left;
            if(target > nums[divide]) {
                left = divide + 1;
            }
            else if(target < nums[divide]) {
                right = divide - 1;
            }
            else return divide;
        }
        return -1;
    }
}

//재귀로 풀기
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        return recursive(nums, low, high, target);
    }

    public int recursive(int[] nums, int low, int high, int target) {
        if(low > high) return -1;
        int mid = (high - low)/2 + low;

        if(nums[mid] == target) return mid;
        else if(target > nums[mid]) return recursive(nums, mid + 1, high, target);
        else return recursive(nums, low, mid - 1, target);
    }
}
