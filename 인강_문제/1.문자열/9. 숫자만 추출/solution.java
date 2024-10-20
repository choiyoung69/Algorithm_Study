import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int solution(String str){
//        int answer = 0;
//
//        for (char x : str.toCharArray()) {
//            if(x >= 48 && x <= 57){
//                answer = answer * 10 + (x - 48);
//            }
//        }
//
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (char x : str.toCharArray()) {
            if(Character.isDigit(x)){
                sb.append(x);
            }
        }

        answer = Integer.parseInt(sb.toString());

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
