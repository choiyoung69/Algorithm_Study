import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class node {
    int x;
    int y;

    public node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main { ;
    int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int answer = 0;
    static int[][] arr;

    public void BFS(int N, int x, int y) {
        Queue<node> q = new LinkedList<>();
        arr[x][y] = 0;
        q.offer(new node(x, y));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                node poll = q.poll();
                int nodeX = poll.x;
                int nodeY = poll.y;
                for(int j = 0; j < 8; j++) {
                    int nx = nodeX + dx[j];
                    int ny = nodeY + dy[j];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (arr[nx][ny] == 1) {
                        arr[nx][ny] = 0;
                        q.offer(new node(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 1) {
                    answer++;
                    T.BFS(N, i, j);
                }
            }
        }
        System.out.println(answer);
    }
}
