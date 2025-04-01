import java.io.*;
import java.sql.Array;
import java.util.*;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main { ;
    static int N, M;
    static int[][] arr;
    static List<Node> home;
    static List<Node> pizza;
    static Node[] comb;
    static int answer = Integer.MAX_VALUE;
    static int[][] dist; // 거리 계산

    public void DFS(int Level, int start) {
        if(Level == M) {
            int sum = 0;
            for(int i = 0; i < home.size(); i++) {
                int min = Integer.MAX_VALUE;
                for(int j = 0; j < M; j++) {
                    int p = pizza.indexOf(comb[j]);
                    min = Math.min(min, dist[i][p]);
                }
                sum += min;
                if(sum >= answer) return;
            }
            answer = Math.min(sum, answer);
        }
        else {
            for(int i = start; i < pizza.size(); i++) {
                comb[Level] = pizza.get(i);
                DFS(Level + 1 ,  i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        home = new ArrayList<>();
        pizza = new ArrayList<>();
        comb = new Node[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) home.add(new Node(i, j));
                if(arr[i][j] == 2) pizza.add(new Node(i, j));
            }
        }

        dist = new int[home.size()][pizza.size()];
        for(int i = 0; i < home.size(); i++) {
            for(int j = 0; j < pizza.size(); j++){
                dist[i][j] = Math.abs(home.get(i).x - pizza.get(j).x) + Math.abs(home.get(i).y - pizza.get(j).y);
            }
        }


        T.DFS(0, 0);
        System.out.println(answer);
    }
}
