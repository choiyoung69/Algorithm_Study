import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static String solution(String str){
        StringBuilder answer = new StringBuilder();
        str += " ";
        int cnt = 1;

        for(int i = 0; i < str.length() - 1; i++){
            if(str.charAt(i) == str.charAt(i+1)) cnt++;
            else if(str.charAt(i) != str.charAt(i+1)){
                answer.append(str.charAt(i));
                if (cnt > 1) answer.append(cnt);
                cnt = 1;
            }
        }


        return answer.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }
}
