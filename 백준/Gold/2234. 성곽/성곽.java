import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int dy[] = {0, -1, 0, 1};
    private static int dx[] = {-1, 0, 1, 0};
    private static int N;
    private static int M;
    private static int cnt;
    private static int max = Integer.MIN_VALUE;
    private static int[][] arr = new int[51][51];
    private static int[][] visited = new int[51][51];
    private static int[] sizeArr = new int[2504];

    public static int dfs(int x, int y, int cnt) {
        if(visited[y][x] != 0) return 0;
        visited[y][x] = cnt;

        int ret = 1;
        for (int i = 0; i < 4; i++) {
            if ((arr[y][x] & (1 << i)) == 0) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                ret += dfs(nx, ny, cnt);
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    cnt++;
                    sizeArr[cnt] = dfs(j, i, cnt);  // 방크기 저장
                    max = Math.max(max, sizeArr[cnt]);
                }
            }
        }

        int sumMax = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    int a = visited[i][j + 1];
                    int b = visited[i][j];
                    if (a != b) {
                        sumMax = Math.max(sumMax, sizeArr[a] + sizeArr[b]);
                    }
                }

                if (i + 1 < M) {
                    int a = visited[i + 1][j];
                    int b = visited[i][j];
                    if (a != b) {
                        sumMax = Math.max(sumMax, sizeArr[a] + sizeArr[b]);
                    }
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
        System.out.println(sumMax);
    }
}
