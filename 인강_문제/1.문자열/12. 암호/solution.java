import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static String solution(int N, String str){
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < N; i++){
            String token = str.substring(i * 7, (i+1)*7).
                                        replace('#', '1').
                                        replace('*', '0');

            int number = Integer.parseInt(token, 2);
            answer.append((char)number);
        }

        return answer.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.println(solution(N, str));
    }
}
