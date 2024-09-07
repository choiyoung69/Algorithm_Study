import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        //분모의 최대공약수를 구하는 과정
        int A = b1;
        int B = b2;
        while(B != 0){
            int r = A % B;

            A = B;
            B = r;
        }

        int b1_divide_divisor = b1/A;
        int b2_divide_divisor = b2/A;
        int numerator = (a1*b2_divide_divisor) + (a2 * b1_divide_divisor);
        int denominator = b1 * b2 / A;

        int A2 = numerator;
        int B2 = denominator;
        //분모 분자에서 최대공약수를 나눈 소인수값
        while(B2 != 0){
            int r = A2 % B2;

            A2 = B2;
            B2 = r;
        }

        System.out.println(numerator/A2 + " " + denominator/A2);
    }
}