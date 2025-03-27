import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] answer;
    static boolean[] check;
    static int[] arr;

    public void DFS(int L) {
        if(L == M) {
            for(int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else {
            for(int i = 0; i < N; i++){
                if(check[i]) continue;
                answer[L] = arr[i];
                check[i] = true;
                DFS(L + 1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = new int[M];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        T.DFS(0);
    }
}
