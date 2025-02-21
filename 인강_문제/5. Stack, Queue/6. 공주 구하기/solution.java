import java.io.*;
import java.util.*;

public class Main {
    public int solution(int N, int K) {
        int answer = 0;
		Queue<Integer> q = new LinkedList<>();
      	for(int i = 1; i <= N; i++) q.offer(i);
      
      	while(!q.isEmpty()){
          	for(int i = 1; i < K; i++){
              	q.offer(q.poll());
            }
       		q.poll();
          	if(q.size() == 1) answer = q.poll();
        }

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
