import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] arr;
    private static int[] result;
    private static int idx = 0;

    public static void dfs(int current, int count) {
        if (count == N - 1) {
            result[current] = arr[idx];
            idx++;
            return;
        }

        dfs(2 * current + 1, count + 1);
        result[current] = arr[idx];
        idx++;
        dfs(2 * current + 2, count + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[(int)Math.pow(2, N) - 1];
        result = new int[(int)Math.pow(2, N) - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = idx; j < idx + Math.pow(2, i);  j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
            idx += Math.pow(2, i);
        }
    }
}