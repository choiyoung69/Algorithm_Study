import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    private static int[][] arr, visited;
    private static int N, M;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int max = Integer.MIN_VALUE;

    public static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] != 0) continue;
            visited[nx][ny] = 2;
            DFS(nx, ny);
        }
    }

    public static void go(int start, int count) {
        if (count == 3) {
            visited = new int[N][M];
            for (int i = 0; i < N; i++) {
                visited[i] = arr[i].clone();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 2) {
                        DFS(i, j);
                    }
                }
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(visited[i][j] == 0) cnt++;
                }
            }
            if(cnt > max) max = cnt;
        }
        else {
            for (int idx = start; idx < N * M; idx++) {
                int x = idx / M;
                int y = idx % M;
                if (arr[x][y] == 0) {
                    arr[x][y] = 1;
                    go(idx + 1, count + 1);
                    arr[x][y] = 0;
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0, 0);
        System.out.println(max);
    }
}
