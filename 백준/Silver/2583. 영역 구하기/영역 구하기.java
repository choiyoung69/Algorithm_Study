import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    private static int M, N, K, cnt;
    private static int[][] a;
    private static int[][] visited;
    private static int dy[] = {-1, 0, 1, 0};
    private static int dx[] = {0, 1, 0, -1};
    private static List<Integer> ret = new ArrayList<>();

    public static void go(int y, int x) {
        visited[y][x] = 1;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= M || nx < 0 || nx >= N|| a[ny][nx] == 1) continue;
            if (visited[ny][nx] == 1) continue;
            go(ny, nx);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        a = new int[M][N];
        visited = new int[M][N];

        int lx, ly, rx, ry;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            lx = Integer.parseInt(st.nextToken());
            ly = Integer.parseInt(st.nextToken());
            rx = Integer.parseInt(st.nextToken());
            ry = Integer.parseInt(st.nextToken());

            for (int j = ly; j < ry; j++) {
                for (int k = lx; k < rx; k++) {
                    a[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] == 0 && visited[i][j] != 1) {
                    go(i, j);
                    ret.add(cnt);
                    cnt = 0;
                }
            }
        }

        System.out.println(ret.size());
        Collections.sort(ret);
        for (int x : ret) {
            System.out.print(x + " ");
        }
    }
}
