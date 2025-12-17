import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] input;
    private static boolean[][][] visited = new boolean[64][64][64];
    private static int[][] d = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 3, 9},
            {1, 9, 3}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        input = new int[3];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(input);
        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            count++;

            while (size != 0) {   // 크기만큼 반복
                int[] polled = q.poll();

                for (int i = 0; i < 6; i++) {
                    int[] result = new int[3]; //새로 저장할 배열
                    int[] selected = d[i]; // 6개의 감소 선택지 중 하나 선택

                    for (int j = 0; j < N; j++) {
                        result[j] = polled[j] - selected[j];
                    }
                    if (extracted(result, count)) {
                        return;
                    }
                    int a = result[0], b = result[1], c = result[2];
                    if(a < 0) a = 0;
                    if(b < 0) b = 0;
                    if(c < 0) c = 0;

                    //방문한 적이 있는지(계산된 적이 있는지) 확인
                    if(!visited[a][b][c]){
                        visited[a][b][c] = true;
                        q.add(result);
                    }
                }

                size--;
            }
        }
    }

    private static boolean extracted(int[] result, int count) {
        boolean flag = false;
        for (int j = 0; j < N; j++) {
            if(result[j] > 0) flag = true;
        }
        if (!flag) {
            System.out.println(count);
            return true;
        }
        return false;
    }
}