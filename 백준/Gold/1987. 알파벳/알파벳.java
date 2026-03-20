import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int count = 0;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int R, C;
    private static char[][] arr;

    public static void dfs(int y, int x, int visited, int now) {
        count = Math.max(count, now);

        visited |= (1 << (arr[y][x] - 'A')); //현재 비트 켜기

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= C || ny >= R) continue;

            // 이미 방문한 곳이면 방문 X
            int bit = 1 << (arr[ny][nx] - 'A');
            if ((visited & bit) != 0) continue;

            dfs(ny, nx, visited | bit, now + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }
        int startBit = 1 << (arr[0][0] - 'A');
        dfs(0, 0, startBit, 1);
        System.out.println(count);
    }
}
