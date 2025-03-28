import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;

    public void DFS(int sum, int count) {
        if(sum > M) return;
        if(count > answer) return;
        if(sum == M) {
            answer = Math.min(count, answer);
        } else{
            for(int i = N - 1; i >= 0; i--){
                DFS(sum + arr[i], count + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());

        T.DFS(0, 0);
        System.out.println(answer);
    }
}
