import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Deque<int[]> dq = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(st.nextToken());
            dq.addLast(new int[]{i + 1, value});
        }

        int k = dq.removeFirst()[1];
        sb.append(1).append(" ");

        while (!dq.isEmpty()) {
            if(k < 0){
                for(int i = k + 1; i < 0; i++){
                    dq.addFirst(dq.removeLast());
                }
                int[] tmp = dq.removeLast();
                sb.append(tmp[0]).append(" ");
                k = tmp[1];
            }
            else{
                for(int i = 0; i < k - 1; i++){
                    dq.addLast(dq.removeFirst());
                }
                int[] tmp = dq.removeFirst();
                sb.append(tmp[0]).append(" ");
                k = tmp[1];
            }
        }
        System.out.println(sb);
    }
}