import java.io.*;
import java.util.*;

public class Main {
    public int solution(int N, int K) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        int last = 0;
        while(!q.isEmpty()){
            for (int i = 0; i < K - 1; i++) {
                q.add(q.poll());
            }
            last = q.poll();
        }
        answer = last;

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(main.solution(N, K));
    }
}
