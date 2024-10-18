import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static String solution(String str){
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            if(str.indexOf(str.charAt(i)) == i) answer.append(str.charAt(i));
        }
        return answer.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
