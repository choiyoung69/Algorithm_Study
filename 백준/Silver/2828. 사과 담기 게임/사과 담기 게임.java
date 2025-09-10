import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main
{
    private static int N, M, J, left, right;
    private static int length;
    private static int[] a;

    public static void go() {
        left = 1;
        right = M;

        for (int i = 0; i < J; i++) {
            if(left <= a[i] && a[i] <= right) continue;
            else if(left > a[i]){
                length += (left - a[i]);
                left = a[i];
                right = a[i] + M - 1;
            }
            else if(right < a[i]){
                length += (a[i] - right);
                left = left + a[i] - right;
                right = a[i];
            }
        }
        System.out.println(length);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        J = Integer.parseInt(br.readLine());
        a = new int[J];

        for (int i = 0; i < J; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        go();
    }
}