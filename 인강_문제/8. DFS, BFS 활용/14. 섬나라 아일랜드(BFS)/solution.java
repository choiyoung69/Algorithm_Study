import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main { ;
    int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int N;
    static int answer = 0;
    public void BFS(int x, int y, int[][] arr) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));

        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == 1) {
                    arr[nx][ny] = 0;
                    Q.add(new Point(nx, ny));
                }
            }
        }
    }

    public void solution(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 1) {
                    answer++;
                    arr[i][j] = 0;
                    BFS(i, j, arr);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        T.solution(arr);
        System.out.println(answer);
    }
}
