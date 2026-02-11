import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static char[][] arr;
    private static boolean[] visited = new boolean[30];
    private static int M;
    private static int N;
    private static int max = 1;

    public static void dfs(int cy, int cx, int count) {
        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(visited[arr[ny][nx] - 'A']) continue;

            max = Math.max(max, count + 1);

            visited[arr[ny][nx] - 'A'] = true;
            dfs(ny, nx, count + 1);
            visited[arr[ny][nx] - 'A'] = false;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        visited[arr[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }
}