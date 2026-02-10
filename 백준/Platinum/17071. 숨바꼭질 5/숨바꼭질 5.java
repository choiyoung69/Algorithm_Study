import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_VALUE = 500000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[][] visited = new boolean[MAX_VALUE + 1][2];
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        int time = 0;

        if (N == K) {
            System.out.println(0);
            return;
        }

        visited[N][0] = true;
        q.add(N);

        while (!q.isEmpty()) {
            time++;
            int size = q.size();
            int parity = time % 2;

            int kPos = K + time * (time + 1) / 2;
            if (kPos > MAX_VALUE) break;

            for (int i = 0; i < size; i++) {
                int current = q.poll();

                int[] nexts = {current - 1, current + 1, current * 2};

                for (int next : nexts) {
                    if(next < 0 || next > MAX_VALUE) continue;
                    if(visited[next][parity]) continue;
                    visited[next][parity] = true;
                    q.add(next);
                }
            }

            if (visited[kPos][parity]) {
                System.out.println(time);
                return;
            }
        }

        System.out.println(-1);
    }
}