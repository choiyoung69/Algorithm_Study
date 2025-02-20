import java.io.*;
import java.util.*;

public class Main {
    public List<Integer> solution(int N, int k, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        int lt = 0;
        for (int i = 0; i < k - 1; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        for (int rt = k - 1; rt < N; rt++) {
            m.put(arr[rt], m.getOrDefault(arr[rt], 0) + 1);
            answer.add(m.size());
            m.put(arr[lt], m.get(arr[lt]) - 1);
            if(m.get(arr[lt]) == 0) m.remove(arr[lt]);
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int result : main.solution(N, k, arr)) {
            System.out.print(result + " ");
        }
    }
}
