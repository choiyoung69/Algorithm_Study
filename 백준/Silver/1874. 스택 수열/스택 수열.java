import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i< N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        String str = stackcount(arr, N);

        if(str.equals("NO")) System.out.println(str);
        else System.out.println(sb);
    }

    static String stackcount(int[] arr, int N){
        Stack<Integer> s = new Stack<>();
        int n = 1;
        for(int i = 0; i < N; i++){
            while(arr[i] >= n){
                s.push(n);
                sb.append("+").append("\n");
                n++;
            }
            if(arr[i] == s.peek()) {
                s.pop();
                sb.append("-").append("\n");
            }
            else if(arr[i] < n) return "NO";
        }
        return "Yes";
    }
}