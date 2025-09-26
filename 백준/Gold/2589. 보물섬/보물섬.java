import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Main
{
    private static int N, M, max;
    private static char[][] arr;
    private static int[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void go(int y, int x) {
        Queue<Point> q = new LinkedList<>();
        visited = new int[N][M];
        visited[y][x] = 1;
        q.add(new Point(y, x));

        while (!q.isEmpty()) {
            Point point = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N || arr[ny][nx] == 'W') continue;
                if (visited[ny][nx] != 0) continue;
                q.add(new Point(ny, nx));
                visited[ny][nx] = visited[point.y][point.x] + 1;

                max = Math.max(max, visited[ny][nx] - 1);
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'L') {
                    go(i, j);
                }
            }
        }

        System.out.println(max);
    }
}