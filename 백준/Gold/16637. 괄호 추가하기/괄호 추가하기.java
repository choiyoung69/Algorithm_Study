import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] numbers;
    private static char[] operators;
    private static int max = Integer.MIN_VALUE;
    private static int ret = 0;

    public static int calculate(char ch, int a, int b) {
        if(ch == '+') return a + b;
        else if(ch == '-') return a - b;
        return a * b;
    }

    public static void dfs(int current, int sum) {
        if (current == numbers.length - 1) {
            max = Math.max(sum, max);
            return;
        }

        dfs(current + 1, calculate(operators[current], sum, numbers[current + 1]));
        if (current + 2 < numbers.length) {
            int temp = calculate(operators[current + 1], numbers[current + 1], numbers[current + 2]);
            dfs(current + 2, calculate(operators[current], sum, temp));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());   //9

        int operator = N / 2;    //4
        int number = N - operator;  //5

        numbers = new int[number];
        operators = new char[operator];

        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                numbers[i / 2] = str.charAt(i) - '0';
            } else {
                operators[i / 2] = str.charAt(i);
            }
        }
        dfs(0, numbers[0]);
        System.out.println(max);
    }
}
