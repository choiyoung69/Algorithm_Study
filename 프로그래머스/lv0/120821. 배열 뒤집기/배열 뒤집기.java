class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {};
        int n = 0;
        int length = num_list.length;
        int temp;
        
        while(n < length/2){
            temp = num_list[n];
            num_list[n] = num_list[length - 1 - n];
            num_list[length - 1 - n] = temp;
            n++;
        }
        answer = num_list;
        return answer;
    }
}