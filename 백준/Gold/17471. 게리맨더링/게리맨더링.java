import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pair {
    int count, sum;
    Pair(int count, int sum) {
        this.count = count;
        this.sum = sum;
    }
}

public class Main {
    private static int N;
    private static int[] population;
    private static List<List<Integer>> arr;
    private static int[] comp = new int[11];
    private static boolean[] visited = new boolean[11];
    private static int ret = Integer.MAX_VALUE;

    public static Pair dfs(int here, int value) {
        visited[here] = true;

        Pair pair = new Pair(1, population[here]);

        for (int there : arr.get(here)) {
            if (comp[there] != value) continue;
            if(visited[there]) continue;

            Pair temp = dfs(there, value);
            pair.count += temp.count;
            pair.sum += temp.sum;
        }
        return pair;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        population = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new ArrayList<>());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                arr.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i < (1 << N) - 1; i++) {
            comp = new int[11];
            visited = new boolean[11];

            int idx1 = -1, idx2 = -1;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    comp[j + 1] = 1;
                    idx1 = j + 1;
                }
                else idx2 = j + 1;
            }
            Pair comp1 = dfs(idx1, 1);
            Pair comp2 = dfs(idx2, 0);

            if (comp1.count + comp2.count == N) {
                ret = Math.min(ret, Math.abs(comp1.sum - comp2.sum));
            }
        }
        if (ret == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else System.out.println(ret);
    }
}
