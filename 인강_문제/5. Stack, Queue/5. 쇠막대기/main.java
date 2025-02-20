import java.io.*;
import java.util.*;

public class Main {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(i > 0 && s.charAt(i - 1) == '('  && s.charAt(i) == ')') {
                stack.pop();
                stack.push('*');
            }
            else if(s.charAt(i) == '(') stack.push('(');
            else {
                int cnt = 0;
                char k = stack.pop();
                while(k != '('){
                    if(k == '*') cnt++;
                    k = stack.pop();
                }
                if(!stack.isEmpty()){
                    for(int j = 0; j < cnt; j++) {
                        stack.push('*');
                    }
                }
                answer += (cnt + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(main.solution(s));
    }
}
