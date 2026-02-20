import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean isLexSmaller(int a, int b, int N) {
        int[] A = new int[N];
        int[] B = new int[N];
        int lenA = 0, lenB = 0;

        for (int i = 0; i < N; i++) {
            if ((a & (1 << i)) != 0) A[lenA++] = i;
            if ((b & (1 << i)) != 0) B[lenB++] = i;
        }

        int minLen = Math.min(lenA, lenB);
        for (int k = 0; k < minLen; k++) {
            if (A[k] != B[k]) return A[k] < B[k];
        }
        // 여기까지 같으면 더 짧은 쪽이 사전순으로 더 빠름 (prefix 규칙)
        return lenA < lenB;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int mp = Integer.parseInt(st.nextToken());
        int mf = Integer.parseInt(st.nextToken());
        int ms = Integer.parseInt(st.nextToken());
        int mv = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][5];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE;
        int answer = 0;
        int M = 1 << N;

        for (int i = 1; i < M; i++) {
            int p = 0, f = 0, s = 0, v = 0, money = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    p += arr[j][0];
                    f += arr[j][1];
                    s += arr[j][2];
                    v += arr[j][3];
                    money += arr[j][4];
                }
            }
            if(p < mp || f < mf || s < ms || v < mv) continue;
            if ((min > money) || (min == money && isLexSmaller(i, answer, N))) {
                min = money;
                answer = i;
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
            for (int i = 0; i < N; i++) {
                if ((answer & (1 << i)) != 0) {
                    System.out.print((i + 1) + " ");
                }
            }
        }
    }
}
