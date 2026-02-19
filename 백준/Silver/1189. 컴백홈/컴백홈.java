import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    private static int R, C, K;
    private static char[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int result = 0;
    private static int targetX, targetY;

    public static void dfs(int y, int x, int count) {
        if(count > K) return;
        if (count == K) {
            if(x == targetX && y == targetY) result++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx == C || ny == R) continue;
            if(visited[ny][nx]) continue;
            if(arr[ny][nx] == 'T') continue;

            visited[ny][nx] = true;
            dfs(ny, nx, count + 1);
            visited[ny][nx] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        targetX = C - 1;
        targetY = 0;

        arr = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);

        System.out.println(result);
    }
}
