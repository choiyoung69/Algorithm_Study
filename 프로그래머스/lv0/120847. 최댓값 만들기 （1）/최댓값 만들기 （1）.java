class Solution {
    public int solution(int[] numbers) {
        int answer = numbers[0];
        int max = 0;
        
        for(int i = 0; i < numbers.length-1; i++){
            for(int j = i+1; j < numbers.length; j++){
                max = numbers[i]*numbers[j];
                if(answer < max)
                    answer = max;
            }
        }
        return answer;
    }
}