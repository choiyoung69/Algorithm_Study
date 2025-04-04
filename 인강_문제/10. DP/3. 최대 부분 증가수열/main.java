import java.io.*;
import java.util.*;

public class Main {

    public int solution(int N, int[] arr) {
        int[] tmp = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            int now = arr[i];
            int max = 0;
            for (int j = i + 1; j < N; j++) {
                if(now >  arr[j]) continue;
                if(tmp[j] > max) {
                    max = tmp[j];
                }
            }

            tmp[i] = max + 1;
        }

        int max = Integer.MIN_VALUE;
        for (int i : tmp) {
            if(i > max) max = i;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr  = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(N, arr));
    }
}
