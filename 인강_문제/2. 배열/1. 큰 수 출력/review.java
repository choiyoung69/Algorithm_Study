import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int CHAR_LENGTH = 7;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(arr[0]).append(' ');
        for(int i = 1; i < n; i++){
            if(arr[i - 1] < arr[i]) sb.append(arr[i]).append(' ');
        }

        System.out.println(sb);
    }
}
