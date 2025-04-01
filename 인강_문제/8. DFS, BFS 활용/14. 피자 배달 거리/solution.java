import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main { ;
    static int N, M, len, answer = Integer.MAX_VALUE;
    static int combi[];
    static ArrayList<Point> pizza, home;

    public void DFS(int Level, int start) {
        if(Level == M) {
            int sum = 0;
            for (Point h : home) {
                int dis = Integer.MAX_VALUE;
                for(int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x - pizza.get(i).x) + Math.abs(h.y - pizza.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        }
        else {
            for (int i = start; i < len; i++) {
                combi[Level] = i;
                DFS(Level + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        combi = new int[M];
        pizza = new ArrayList<>();
        home = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp  = Integer.parseInt(st.nextToken());
                if(tmp == 1) home.add(new Point(i, j));
                if(tmp == 2) pizza.add(new Point(i, j));
            }
        }

        len = pizza.size();
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
