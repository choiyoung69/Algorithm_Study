import java.io.*;
import java.util.*;

public class Main {

    public int solution(int N, int[] arr) {
        int answer = 0;
        int[] tmp = new int[N];

        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i] && tmp[j] > max) {
                    max = tmp[j];
                }
            }
            tmp[i] = max + 1;
            answer = Math.max(answer, tmp[i]);
        }

        return answer;
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
