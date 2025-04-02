import java.io.*;
import java.util.*;

class Schedule implements Comparable<Schedule> {
    int m, d;

    public Schedule(int m, int d) {
        this.m = m;
        this.d = d;
    }

    @Override
    public int compareTo(Schedule o) {
        return o.d - this.d;
    }
}

public class Main { ;
    public int solution(ArrayList<Schedule> arr, int max, int n) {
        int answer = 0;
        Collections.sort(arr);
        PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;
        for(int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if(arr.get(j).d < i) break;
                PQ.offer(arr.get(j).m);
            }
            if(!PQ.isEmpty()) {
                answer += PQ.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Schedule> arr = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if(max < d) max = d;
            arr.add(new Schedule(m, d));
        }

        System.out.println(T.solution(arr, max, N));
    }
}
