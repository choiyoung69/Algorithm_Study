import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Deque<Character> dq = new ArrayDeque<>();
        
        for(char ch : s.toCharArray()) {
            if(!dq.isEmpty() && dq.peek() == ch) {
                dq.pop();
            } else {
                dq.push(ch);
            }
        }
        
        if(dq.isEmpty()) {
            answer = 1;
        } else {
            answer = 0;
        }

        return answer;
    }
}