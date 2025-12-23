import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] dist = new int[100004];
    private static int[] prev = new int[100004];
    private static int N;
    private static int K;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1);
        dist[N] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        while (!q.isEmpty()) {
            int current = q.poll();

            if (dist[K] != -1) {
                break;
            }

            int[] nexts = {current + 1, current - 1, current * 2};
            for (int next : nexts) {
                if(next < 0 || next > 100000 || dist[next] != -1) continue;
                dist[next] = dist[current] + 1;
                prev[next] = current;
                q.add(next);
            }
        }

        System.out.println(dist[K]);
//        System.out.println(prev[K]);
        List<Integer> list = new ArrayList<>();
        for(int i = K; i != N; i = prev[i]){
            list.add(i);
        }
        list.add(N);

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}