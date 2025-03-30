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

    public int BFS(int[][] arr) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        int count = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                Node node = q.poll();
                int x = node.x;
                int y = node.y;

                for(int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if(nx < 0 || nx >= 7 || ny < 0 || ny >=7) continue;

                    if(nx == 6 && ny == 6) return ++count;
                    if(arr[nx][ny] == 0) {
                        q.offer(new Node(nx, ny));
                        arr[nx][ny] = 1;
                    }
                }
            }
            count++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[7][7];
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        arr[0][0] = 1;
        System.out.println(T.BFS(arr));
    }
}
