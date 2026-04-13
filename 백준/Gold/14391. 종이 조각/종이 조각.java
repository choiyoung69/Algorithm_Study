import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int ret = 0;

        for (int s = 0; s < (1 << (N * M)); s++) {
            int sum = 0;

            for (int i = 0; i < N; i++) {
                int cur = 0;
                for (int j = 0; j < M; j++) {
                    int k = i * M + j;
                    if ((s & (1 << k)) == 0) {
                        cur = cur * 10 + arr[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            for (int i = 0; i < M; i++) {
                int cur = 0;
                for (int j = 0; j < N; j++) {
                    int k = j * M + i;
                    if ((s & (1 << k)) != 0) {
                        cur = cur * 10 + arr[j][i];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            ret = Math.max(ret, sum);
        }

        System.out.println(ret);
    }
}

