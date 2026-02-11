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
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static char[][] arr;
    private static Queue<Point> water, waterTemp, swan, swanTemp;
    private static boolean[][] visitedSwan, visited;
    private static int M;
    private static int N;

    public static void ice() {
        while (!water.isEmpty()) {
            Point current = water.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (arr[ny][nx] == 'X') {
                    arr[ny][nx] = '.';
                    waterTemp.add(new Point(ny, nx));
                }
            }
        }
    }

    public static boolean swan() {
        while (!swan.isEmpty()) {
            Point current = swan.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if(visitedSwan[ny][nx]) continue;
                visitedSwan[ny][nx] = true;
                if (arr[ny][nx] == '.') swan.add(new Point(ny, nx));
                else if (arr[ny][nx] == 'X') swanTemp.add(new Point(ny, nx));
                else return true;
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visitedSwan = new boolean[N][M];
        visited = new boolean[N][M];
        swan = new LinkedList<>();
        water = new LinkedList<>();
        swanTemp = new LinkedList<>();
        waterTemp = new LinkedList<>();
        int startX = 0, startY = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'L') {
                    startX = j;
                    startY = i;
                }
                if (arr[i][j] == '.' || arr[i][j] == 'L') {
                    water.add(new Point(i, j));
                }
            }
        }

        swan.add(new Point(startY, startX));
        visitedSwan[startY][startX] = true;

        int time = 0;
        while (true) {
            // 백조 옮기기
            if(swan()) break;
            ice();
            swan = swanTemp;
            water = waterTemp;
            swanTemp = new LinkedList<>();
            waterTemp = new LinkedList<>();
            time++;
        }
        System.out.println(time);
    }
}