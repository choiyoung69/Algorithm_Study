import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static char[] arr;
    private static boolean[] visited = new boolean[10];
    private static List<String> result = new ArrayList<>();
    private static char[] temp;

    public static void dfs(int current, int count) {
        if (count == N) {
            result.add(String.valueOf(temp));
            return;
        }
        
        char ch = arr[count];
        if (ch == '>') {
            for (int i = 0; i < current; i++) {
                if(visited[i]) continue; //이미 방문한 적이 있다면 패스
                visited[i] = true;
                temp[count + 1] = (char)(i + '0');
                dfs(i, count + 1);
                visited[i] = false;
            }
        }
        if (ch == '<') {
            for (int i = current; i < 10; i++) {
                if(visited[i]) continue; //이미 방문한 적이 있다면 패스
                visited[i] = true;
                temp[count + 1] = (char)(i + '0');
                dfs(i, count + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N];
        temp = new char[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < 10; i++) {
            temp[0] = (char)(i + '0');
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;
        }

        Collections.sort(result);

        System.out.println(result.get(result.size() - 1));
        System.out.println(result.get(0));
    }
}