import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main { ;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int BFS(int N, int M, int[][] arr) {
        boolean flag = true;
        int days = 0;
        Queue<Node> q = new LinkedList<>();

        //처음 토마토 익었는지 확인 + 익은 토마토 체크
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0) flag = false;
                if(arr[i][j] == 1) q.offer(new Node(i, j));
            }
        }
        if(flag) return 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node temp = q.poll();
                int x = temp.x;
                int y = temp.y;
                for(int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                    if(arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
            days++;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) return -1;
            }
        }

        return days - 1;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(T.BFS(N, M, arr));
    }
}
