import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int ves;
    int cost;

    public Edge(int ves, int cost) {
        this.ves = ves;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    public int solution(int N, int M, int[] dis, ArrayList<ArrayList<Edge>> graph, int start, int end) {
        PriorityQueue<Edge> PQ = new PriorityQueue<Edge>();
        PQ.offer(new Edge(start, 0));
        dis[start] = 0;

        for(int i = 1; i <= N; i++) {
            Edge tmp = PQ.poll();
            int tmpVes = tmp.ves;
            int tmpCost = tmp.cost;
            if(tmpVes == end) {
                return tmpCost;
            }
            if(tmpCost > dis[tmpVes]) continue;
            for(Edge ob : graph.get(tmpVes)) {
                if(dis[ob.ves] > ob.cost + tmpCost) {
                    dis[ob.ves] = ob.cost + tmpCost;
                    PQ.offer(new Edge(ob.ves, dis[ob.ves]));
                }
            }
        }
        return dis[end];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        int[] dis = new int[N+1];
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Edge>());
        }
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(T.solution(N, M, dis, graph, start, end));
    }
}