import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int n = 2;
        for(int i = 0; i < N; i++){
            n = 2 * n - 1;
        }

        System.out.print((int)Math.pow(n, 2));
    }
}