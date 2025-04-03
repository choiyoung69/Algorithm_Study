```java
import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    public int vex;
    public int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    public void solution(int v) {
        //cost가 작을 수록 나온다
        PriorityQueue<Edge> PQ = new PriorityQueue<>();

        //1번 노드 거리 채우기
        PQ.offer(new Edge(1, 0));
        dis[v] = 0;

        while(!PQ.isEmpty()) {
            Edge tmp = PQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost > dis[now]) continue;
            for(Edge ob : graph.get(now)) {
                if(dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost+ob.cost;
                    PQ.offer(new Edge(ob.vex, dis[ob.vex]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Edge>>();

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Edge>());
        }

        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b,c));
        }

        T.solution(1);

        for (int i = 2; i <= N; i++) {
            if(dis[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + dis[i]);
            }
            else System.out.println(i + " : Impossible");
        }
    }
}
```
