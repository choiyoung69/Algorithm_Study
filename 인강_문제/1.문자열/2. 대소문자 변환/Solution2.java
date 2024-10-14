import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static String solution(String str){
        StringBuilder answer = new StringBuilder();

//        for(char x : str.toCharArray()){
//            if(Character.isLowerCase(x)) answer.append(Character.toUpperCase(x));
//            else answer.append(Character.toLowerCase(x));
//        }

        for (char x : str.toCharArray()) {
            if(65 <= x && x <= 90) answer.append((char)(x + 32));
            else answer.append((char) (x - 32));
        }

        return answer.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(Main.solution(str));
    }
}
