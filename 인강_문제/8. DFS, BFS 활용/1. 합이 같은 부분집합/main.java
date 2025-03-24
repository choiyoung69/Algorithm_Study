import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public String DFS(int sum, int v, int level, int N) {
        if(v == sum){
            return "YES";
        }
        else{
            level++;
            if(level == N) return "NO";
            if(v > sum) return "NO";
            if("YES".equals(DFS(sum, v + arr[level], level, N)) || "YES".equals(DFS(sum, v, level, N)))
                return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        if(sum % 2 == 1) System.out.println("NO");
        else System.out.println(T.DFS(sum/2, 0, 0, N));
    }
}
