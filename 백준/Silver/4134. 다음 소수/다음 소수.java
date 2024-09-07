import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        for(int i = 0; i < N; i++){
            long num = Long.parseLong(br.readLine());
            long result = logic(num);
            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }

    public static long logic(long num){
        for(long i = num; ; i++){
            if(isPrime(i)) return i;
        }
    }

    public static boolean isPrime(long num){
        boolean result;
        if(num <= 1) return false;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}