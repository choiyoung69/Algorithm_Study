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

        int N = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if(ch == '(') stack.push('(');
                else if(ch == ')' && stack.isEmpty()) {
                    stack.push(')');
                    break;
                }
                else if(ch == ')') stack.pop();
            }
            if(!stack.isEmpty()) sb.append("NO").append('\n');
            else sb.append("YES").append('\n');
            stack.clear();
        }
        System.out.println(sb);
    }
}