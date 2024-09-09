import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main{
    public static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Stack<Character> stack = new Stack<>();
        while(true){
            String str = br.readLine();
            if(str.charAt(0) == '.') break;

            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(ch == '(' || ch == '[') stack.add(ch);
                else if(stack.isEmpty() && (ch == ')' || ch == ']')) stack.add(ch);
                else if(ch == ')' && stack.peek() == '(') stack.pop();
                else if(ch == ')' && stack.peek() != '(') stack.push(')');
                else if(ch == ']' && stack.peek() == '[') stack.pop();
                else if(ch == ']' && stack.peek() != '[') stack.push(']');
            }
            if(!stack.isEmpty()) sb.append("no").append("\n");
            else sb.append("yes").append("\n");
            stack.clear();
        }
        System.out.println(sb);
    }
}