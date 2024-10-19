import java.util.Locale;
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static String solution(String str){
        String answer = "YES";

        StringBuilder sb = new StringBuilder(str);
        String tmp = sb.reverse().toString();

        if(!str.equalsIgnoreCase(tmp)) return "NO";

//        int len = str.length();
//        for(int i = 0; i < len/2; i++){
//            if(str.charAt(i) != str.charAt(len - i - 1)) return "NO";
//        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
