import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Main
{
    private static int N, M;
    private static int[][] arr;
    private static List<Point> chicken = new ArrayList<>();
    private static List<Point> homes = new ArrayList<>();
    private static List<List<Point>> chickenList = new ArrayList<>();

    public static void go(int start, List<Point> v) {
        if (v.size() == M) {
            chickenList.add(new ArrayList<>(v));
            return;
        }
        for (int i = start + 1; i < chicken.size(); i++) {
            v.add(chicken.get(i));
            go(i, v);
            v.remove(v.size() - 1);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) homes.add(new Point(i, j));
                if(arr[i][j] == 2) chicken.add(new Point(i, j));
            }
        }

        List<Point> v = new ArrayList<Point>();
        go(-1, v);

        int result = Integer.MAX_VALUE;
        for (List<Point> selected : chickenList) {
            int ret = 0;
            for (Point home : homes) {
                int min = Integer.MAX_VALUE;
                for (Point ch : selected) {
                    int now = Math.abs(home.x - ch.x) + Math.abs(home.y - ch.y);
                    if(min > now) min = now;
                }
                ret += min;
            }
            result = Integer.min(ret, result);
        }
        System.out.println(result);
    }
}
