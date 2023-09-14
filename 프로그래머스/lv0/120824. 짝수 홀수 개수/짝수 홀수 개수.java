class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int odd = 0;
        int not_odd = 0;
        int num = 0;
        
        for(int i = 0; i < num_list.length; i++){
            num = num_list[i];
            if(num%2==0)
                odd += 1;
            else{
                not_odd++;
            }
        }
        answer[0] = odd;
        answer[1] = not_odd;
        return answer;
    }
}