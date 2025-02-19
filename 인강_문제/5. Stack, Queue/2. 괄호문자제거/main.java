import java.io.*;
import java.util.*;

public class Main {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if(ch == '(') stack.push(ch);
            else if(ch == ')') stack.pop();
            else if(stack.isEmpty()) answer.append(ch);
        }

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(main.solution(s));
    }
}
