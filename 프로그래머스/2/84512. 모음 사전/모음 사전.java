class Solution {
    public int solution(String word) {
        int answer = 0;
        String[] alpha = {"A", "E", "I", "O", "U"};
        
        for(int i = 0; i < alpha.length; i++){
            String temp = alpha[i];
            answer++;
            if(temp.equals(word)) return answer;
            for(int j = 0; j < alpha.length; j++){
                temp = alpha[i] + alpha[j];
                answer++;
                if(temp.equals(word)) return answer;
                for(int k = 0; k < alpha.length; k++){
                    temp = alpha[i] + alpha[j] + alpha[k];
                    answer++;
                    if(temp.equals(word)) return answer;
                    for(int l = 0; l < alpha.length; l++){
                        temp = alpha[i] + alpha[j] + alpha[k] + alpha[l];
                        answer++;
                        if(temp.equals(word)) return answer;           
                        for(int m = 0; m < alpha.length; m++){
                            temp = alpha[i] + alpha[j] + alpha[k] + alpha[l] + alpha[m];
                            answer++;
                            if(temp.equals(word)) return answer;
                        }
                    }
                }
            }
        }
        return answer;
    }
}