import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int C, N;

    public void DFS(int level , int sum, int[] arr) {
        if(sum > C) return;
        if(level == N) {
            if(answer < sum) answer = sum;
        }
        else{
            DFS(level + 1, sum + arr[level], arr);
            DFS(level + 1, sum, arr);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
