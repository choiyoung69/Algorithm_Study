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
        int X, classy;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            classy = Integer.parseInt(st.nextToken());

            switch(classy){
                case 1:
                    X = Integer.parseInt(st.nextToken());
                    stack.add(X);
                    break;
                case 2:
                    if(!stack.isEmpty()) sb.append(stack.pop()).append("\n");
                    else sb.append("-1\n");
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
                    break;
                case 4:
                    if(stack.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case 5:
                    if(!stack.isEmpty()) sb.append(stack.peek()).append("\n");
                    else sb.append("-1\n");
            }
        }
        System.out.println(sb);
    }
}