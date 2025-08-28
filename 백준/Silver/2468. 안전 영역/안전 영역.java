import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    private static int N, count;
    private static int[][] a;
    private static int[][] visited;
    private static int dy[] = {-1, 0, 1, 0};
    private static int dx[] = {0, 1, 0, -1};

    public static void go(int y, int x, int rain) {
        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            if (visited[ny][nx] == 1) continue;
            if (a[ny][nx] > rain) go(ny, nx, rain);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        a = new int[N][N];
        visited = new int[N][N];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if(max < a[i][j]) max = a[i][j];
                if(min > a[i][j]) min = a[i][j];
            }
        }

        int answer = 1, count;
        for (int i = min; i <= max; i++) {
            count = 0;
            visited = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (a[j][k] > i && visited[j][k] != 1) {
                        go(j, k, i);
                        count++;
                    }
                }
            }
            if(count > answer) answer = count;
        }

        System.out.println(answer);
    }
}