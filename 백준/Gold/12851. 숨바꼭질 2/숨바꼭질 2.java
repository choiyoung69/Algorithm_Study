import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] dist = new int[100004];
    private static int[] ways = new int[100004];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        dist[N] = 0;
        ways[N] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (dist[K] != -1 && dist[cur] > dist[K]) break;

            int[] nexts = {cur - 1, cur + 1, cur * 2};
            for (int next : nexts) {
                if(next < 0 || next > 100000) continue;

                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    ways[next] = ways[cur];
                    q.add(next);
                } else if (dist[next] == dist[cur] + 1) {
                    ways[next] += ways[cur];
                }
            }
        }

        System.out.println(dist[K]);
        System.out.println(ways[K]);
    }
}