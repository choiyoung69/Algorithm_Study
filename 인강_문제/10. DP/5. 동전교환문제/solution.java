import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dy;

    public int solution(int[] coin) {
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < N; i++) {
            for(int j = coin[i]; j <= M; j++) {
                if(dy[j] > dy[j - coin[i]] + 1) {
                    dy[j] = dy[j - coin[i]] + 1;
                }
            }
        }
        return dy[M];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        dy = new int[M + 1];
        System.out.println(T.solution(arr));
    }
}
