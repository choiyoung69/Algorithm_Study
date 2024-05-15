class Solution {
    public int solution(String s) {
        int answer = 0;
        
        while(s.length() != 0){
            int count = 1, dcount = 0;
            char x = s.charAt(0);
            int length = s.length();
            
            for(int i = 1; i < length; i++){
                if(x == s.charAt(i)) count++;
                else dcount++;
                
                if(count == dcount){ 
                    answer++; 
                    if((i + 1) != length) {
                        s = s.substring(i+1);
                        break;
                    }
                    else s = "";
                }
            }
            if(s.length() == length){
                answer++;
                break;
            }
        }
        
        return answer;
    }
}