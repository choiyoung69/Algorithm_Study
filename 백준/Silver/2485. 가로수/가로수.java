import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long pre = Integer.parseInt(br.readLine());

        long[] arr = new long[N - 1];

        for(int i = 0; i < N - 1; i++){
            long post = Integer.parseInt(br.readLine());
            arr[i] = post - pre;
            pre = post;
        }

        long gcd = arr[0];
        for (int i = 0; i < arr.length; i++) {
            gcd = gcd(gcd, arr[i]);
        }

        long sum = 0;
        for(long n : arr){
            sum += (n/gcd - 1);
        }
        System.out.println(sum);
    }

    static public long gcd(long A, long B) {
        long r;
        while (B != 0) {
            r = A % B;

            A = B;
            B = r;
        }
        return A;
    }
}