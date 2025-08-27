import java.io.BufferedReader;
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
    private static int N;
    private static int M;
    private static int[][] a = new int[105][105];
    private static int[][] visited = new int[105][105];
    private static int dy[] = {-1, 0, 1, 0};
    private static int dx[] = {0, 1, 0, -1};
    private static Queue<Point> q = new LinkedList<>();

    public static void go(int y, int x) {
        visited[y][x] = 1;
        q.add(new Point(y, x));
        while (!q.isEmpty()) {
            Point point = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];
                if (ny < 1 || ny > N || nx < 1 || nx > M) continue;
                if(visited[ny][nx] != 0) continue;
                if (a[ny][nx] == 1) {
                    visited[ny][nx] = visited[point.y][point.x] + 1;
                    q.add(new Point(ny, nx));
                }
            }
        }

        System.out.println(visited[N][M]);
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                a[i][j] = str.charAt(j - 1) - '0';
            }
        }

        go(1, 1);
    }
}
