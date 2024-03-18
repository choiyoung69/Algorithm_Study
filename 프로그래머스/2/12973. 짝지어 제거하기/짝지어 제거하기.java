import java.util.*;

class Solution
{
    public int solution(String s)
    {   
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(stack.empty()){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.peek() == s.charAt(i)){
                    stack.pop();
                    continue;
                }
                else{
                    stack.push(s.charAt(i));
                }
            }
        }
        if(!stack.empty()){
            return 0;
        }
        else{
            return 1;
        }
    }
}