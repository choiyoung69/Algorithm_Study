import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] visited;
    private static List<List<Integer>> arr;

    public static void dfs(int x) {
        visited[x] = true;

        for (int i : arr.get(x)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());

        for (int i = 0; i < total; i++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            visited = new boolean[N + 1];
            arr = new ArrayList<>();
            for (int j = 0; j <= N; j++) {
                arr.add(new ArrayList<>());
            }

            for (int j = 0; j < M; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr.get(a).add(b);
                arr.get(b).add(a);
            }

            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    dfs(j);
                    cnt++;
                }
            }

            if ((M == N - 1) && (cnt == 1)) {
                System.out.println("tree");
            } else {
                System.out.println("graph");
            }
        }
    }
}
