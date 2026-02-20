import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int maxIdx = 1 << N;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < maxIdx; i++) {
            int result = 0;
            // 행을 모두 뒤집었으면 열을 확인(T의 개수가 적은 걸로 선택)
            for (int col = 0; col < N; col++) {
                int t_count = 0;
                for (int row = 0; row < N; row++) {
                    char cur = arr[row][col];
                    if ((i & (1 << row)) != 0) {
                        cur = (cur == 'T') ? 'H' : 'T';
                    }
                    if(cur == 'T') t_count++;
                }
                result += Math.min(t_count, N - t_count);
            }
            min = Math.min(min, result);
        }
        System.out.println(min);
    }
}
