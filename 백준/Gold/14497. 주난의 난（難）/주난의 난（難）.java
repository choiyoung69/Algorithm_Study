import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
    private static final int MAX_VALUE = 500000;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static char[][] arr;
    private static boolean[][] visited;
    private static int M;
    private static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;
        int x2 = Integer.parseInt(st.nextToken()) - 1;

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        Queue<Point> q = new LinkedList<>();
        visited = new boolean[N][M];
        visited[y1][x1] = true;
        q.add(new Point(y1, x1));
        int time = 0;

        while (!q.isEmpty()) {
            time++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Point now = q.poll();
                if (repeat(q, now.x, now.y)) {
                    System.out.println(time);
                    return;
                }
            }
        }
    }

    private static boolean repeat(Queue<Point> q, int x, int y) {
        if (arr[y][x] == '#') {
            return true;
        }
        for (int j = 0; j < 4; j++) {
            int nx = x + dx[j];
            int ny = y + dy[j];
            if (nx < 0 || ny < 0 || nx >= M || ny >= N || visited[ny][nx]) continue;

            visited[ny][nx] = true;
            if (arr[ny][nx] == '1') {
                q.add(new Point(ny, nx));
                continue;
            }
            if(repeat(q, nx, ny)) return true;
        }
        return false;
    }
}