import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    private static int[] arr;
    private static int N;

    public static void go(int goal) {
        arr[goal] = -2;
        for (int i = 0; i < N; i++) {
            if(arr[i] == goal) go(i);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int goal = Integer.parseInt(br.readLine());
        go(goal);

        int rnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] != -2) {
                boolean flag = false;
                for (int j = 0; j < N; j++) {
                    if(arr[j] == i) flag = true;
                }
                if(!flag) rnt++;
            }
        }
        System.out.println(rnt);
    }
}
