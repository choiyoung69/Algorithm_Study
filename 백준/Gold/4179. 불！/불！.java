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

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] arr = new char[R][C];
        boolean[][] visited = new boolean[R][C];
        Queue<Point> jQ = new LinkedList<>();
        Queue<Point> fireQ = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'J') {
                    visited[i][j] = true;
                    jQ.add(new Point(i, j));
                }
                else if (arr[i][j] == 'F') fireQ.add(new Point(i, j));
            }
        }

        int count = 1;
        while (!jQ.isEmpty()) {
            int fireQSize = fireQ.size();
            for (int i = 0; i < fireQSize; i++) {
                Point fire = fireQ.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = fire.x + dx[j];
                    int ny = fire.y + dy[j];

                    if (nx < 0 || nx >=C || ny < 0 || ny >= R) continue;
                    if(arr[ny][nx] == 'F' || arr[ny][nx] == '#') continue;
                    arr[ny][nx] = 'F';
                    fireQ.add(new Point(ny, nx));
                }
            }

            int jQsize = jQ.size();
            for (int i = 0; i < jQsize; i++) {
                Point now = jQ.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if (nx < 0 || nx >= C || ny < 0 || ny >= R) {
                        System.out.println(count);
                        return;
                    }
                    if(visited[ny][nx] || arr[ny][nx] == 'F' || arr[ny][nx] == '#') continue;
                    jQ.add(new Point(ny, nx));
                    visited[ny][nx] = true;
                }
            }
            count++;
        }

        System.out.println("IMPOSSIBLE");
    }
}