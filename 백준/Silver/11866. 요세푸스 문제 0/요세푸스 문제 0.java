import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            q.offer(i);
        }

        while(!q.isEmpty()){
            for(int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            if(q.size() == 1) sb.append(q.poll());
            else sb.append(q.poll()).append(", ");
        }

        sb.append(">");
        System.out.println(sb);
    }
}