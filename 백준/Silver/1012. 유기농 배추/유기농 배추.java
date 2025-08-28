import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

class Main
{
    private static int T, N, M, K;
    private static int[][] a;
    private static int[][] visited;
    private static int dy[] = {-1, 0, 1, 0};
    private static int dx[] = {0, 1, 0, -1};
    private static int worm = 0;

    public static void go(int y, int x) {
        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
            if (visited[ny][nx] == 1) continue;
            if (a[ny][nx] == 1) go(ny, nx);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        int x, y;
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            a = new int[N][M];
            visited = new int[N][M];
            worm = 0;
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                a[y][x] = 1;
            }
            find();
            System.out.println(worm);
        }
    }

    private static void find() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(a[i][j] == 1 && visited[i][j] != 1){
                    go(i, j);
                    worm++;
                }
            }
        }
    }
}
