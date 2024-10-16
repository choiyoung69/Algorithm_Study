import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static String solution(String str){
        String answer = "";
        int m = Integer.MIN_VALUE;
        int pos;
//        String[] arr = str.split(" ");
//
//        for(String x : arr){
//            if(x.length() > m) {
//                m = x.length();
//                answer = x;
//            }
//        }

        while((pos = str.indexOf(' ')) != -1){
            String tmp = str.substring(0, pos);
            if(tmp.length() > m){
                m = tmp.length();
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }
        if(str.length() > m) answer = str;

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(Main.solution(str));
    }
}
