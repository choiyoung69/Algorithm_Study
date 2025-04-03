import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public String solution(int f1, int f2) {
        String answer;

        int root1 = find(f1);
        int root2 = find(f2);

        if(root1 == root2) answer = "YES";
        else answer = "NO";

        return answer;
    }

    public int find(int x) {
        if(x == parent[x]){
            return x;
        }
        else return find(parent[x]);
    }

    public void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);

        if(root1 < root2) {
            parent[root2] = root1;
        }
        else parent[root1] = root2;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            T.union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int f1 = Integer.parseInt(st.nextToken());
        int f2 = Integer.parseInt(st.nextToken());

        System.out.println(T.solution(f1, f2));
    }
}
