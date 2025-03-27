import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] answer;
    static boolean[] check;

    public void DFS(int L, int[] arr) {
        if(L == M) {
            for(int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else {
            for(int i = 0; i < arr.length; i++){
                if(check[i]) continue;
                answer[L] = arr[i];
                check[i] = true;
                DFS(L + 1, arr);
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

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        answer = new int[N - 1];
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        T.DFS(0, arr);
    }
}
