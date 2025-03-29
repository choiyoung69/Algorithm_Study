import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N;
    static int total;
    static int[] checked;
    static int[] answer;
    boolean flag = false;

    public void DFS(int L) {
        if(L == N) {
            Queue<Integer> temp = new LinkedList<>();
            for(int i = 0; i < N; i++){
                temp.add(answer[i]);
            }

            while(temp.size() > 1) {
                int size = temp.size() - 1;
                for(int i = 0; i < size; i++) {
                    temp.add(temp.poll() + temp.peek());
                }
                temp.poll();
            }

            if(temp.peek() == total) {
                flag = true;
            }
        }
        else {
            for(int i = 0; i < N; i++){
                if(checked[i] != 1) {
                    checked[i] = 1;
                    answer[L] = arr[i];
                    DFS(L+1);
                    checked[i] = 0;
                }
                if(flag) return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        total = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = i+1;
        }
        checked = new int[N];
        answer = new int[N];

        T.DFS(0);

        for(int x : answer) {
            System.out.print(x + " ");
        }
    }
}
