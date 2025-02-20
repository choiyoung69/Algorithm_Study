import java.io.*;
import java.util.*;

public class Main {
    public int solution(int N, int M, int[] arr) {
        int answer = 0;
        LinkedList<Integer> q = new LinkedList<>();
        LinkedList<Integer> index = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            index.add(i);
        }

        for(int x : arr){
            q.add(x);
        }

        while(!q.isEmpty()){
            int max = q.peek();
            for (int i = 0; i < q.size(); i++) {
                if(q.get(i) > max){
                    max = q.get(i);
                }
            }
            int target = q.indexOf(max);
            for (int j = 0; j < target; j++) {
                q.add(q.poll());
                index.add(index.poll());
            }
            count++;
            if(index.peek() == M){
                answer = count;
                break;
            }
            q.poll();
            index.poll();
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution(N, M, arr));
    }
}
