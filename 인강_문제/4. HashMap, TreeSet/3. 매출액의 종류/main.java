import java.io.*;
import java.util.*;

public class Main {
    public int[] solution(int N, int k, int[] arr) {
        int[] answer = new int[N - k + 1];
        int lt = 0, rt = 0;
        Map<Integer, Integer> m = new HashMap<>();

        for(rt = 0; rt < N; rt++) {
            if(rt - lt + 1 == k){
                if(m.containsKey(arr[rt])) m.put(arr[rt], m.get(arr[rt]) + 1);
                else m.put(arr[rt], 1);

                answer[lt] = m.size();

                if(m.get(arr[lt]) == 1) m.remove(arr[lt]);
                else m.put(arr[lt], m.get(arr[lt]) - 1);
                lt++;
            }
            else{
                if(m.containsKey(arr[rt])) m.put(arr[rt], m.get(arr[rt]) + 1);
                else m.put(arr[rt], 1);
            }
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
