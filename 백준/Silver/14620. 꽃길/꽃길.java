import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
    private static int N;
    private static int min = Integer.MAX_VALUE;
    private static final int FLOWER_COUNT = 3;
    private static int[][] arr;
    private static List<Point> flowers = new ArrayList<>();
    private static boolean[][] visited;
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void dfs(int y, int x, int count) {
        if (count == FLOWER_COUNT) {
            int sum = 0;
            for (Point p : flowers) {
                sum += arr[p.y][p.x];
            }
            min = Math.min(min, sum);
            return;
        }

        for(int i = y; i < N; i++) {
            int startJ = (i == y ? x : 0);
            for (int j = startJ; j < N; j++) {
                // 해당 점과 꽃잎 좌표에 방문한 적이 있는지 확인.
                if(visited[i][j]) continue;
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx]) {
                        flag = false;
                        break;
                    }
                }
                // 만약 모두 다 방문한 기록이 없다면
                if (flag) {
                    visited[i][j] = true;
                    flowers.add(new Point(i, j));
                    for (int k = 0; k < 4; k++) {
                        visited[i + dy[k]][j + dx[k]] = true;
                        flowers.add(new Point(i + dy[k], j + dx[k]));
                    }
                    dfs(i, j, count + 1);
                    visited[i][j] = false;
                    flowers.remove(flowers.size() - 1);
                    for (int k = 0; k < 4; k++) {
                        visited[i + dy[k]][j + dx[k]] = false;
                        flowers.remove(flowers.size() - 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        System.out.println(min);
    }
}