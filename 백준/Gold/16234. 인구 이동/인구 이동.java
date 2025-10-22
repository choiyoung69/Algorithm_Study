import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point{
    int x;
    int y;

    public Point(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

class Main
{
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int N, L, R;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int peopleSum;
    public static List<Point> list = new ArrayList<>();

    public static void dfs(int y, int x){
        visited[y][x] = true;
        list.add(new Point(y, x));
        peopleSum += arr[y][x];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx]) continue;
            int value = Math.abs(arr[ny][nx] - arr[y][x]);
            if(value >= L && value <= R) {
                dfs(ny, nx);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean change;
        int day = 0;

        while (true) {
            change = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        peopleSum = 0;
                        list = new ArrayList<>();

                        dfs(i, j);

                        if(list.size() == 1) continue;
                        change = true;
                        for (Point p : list) {
                            arr[p.y][p.x] = peopleSum / list.size();
                        }
                    }
                }
            }

            if(!change) break;
            day++;
        }

        System.out.println(day);
    }
}
