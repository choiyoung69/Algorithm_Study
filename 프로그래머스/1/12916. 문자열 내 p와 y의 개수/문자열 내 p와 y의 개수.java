class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int countP = 0, countY = 0;
        
        String upperS = s.toUpperCase();
        for(char ch : upperS.toCharArray()){
            if(ch == 'P') countP++;
            if(ch == 'Y') countY++;
        }
        if(countP != countY) answer = false;
        return answer;
    }
}