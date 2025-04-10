import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public int solution(int N, int[] arr) {
        for(int i = 2; i <= N; i++) {
            for(int j = 1; j <= i / 2; j++) {
                arr[i] = Math.max(arr[i], arr[j] + arr[i - j]);
            }
        }

        return arr[N];
    }

    public static void main(String[] args) throws IOException{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution(N, arr));
    }
}