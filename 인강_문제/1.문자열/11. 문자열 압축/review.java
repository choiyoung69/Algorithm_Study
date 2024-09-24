import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            int count = 1;
            int last = 0;

            //만약 마지막 index라면 break;
            if(i == str.length() - 1){
                sb.append(str.charAt(i));
                break;
            }

            //몇 개가 존재하는지 세보기
            for(int j = i + 1; j < str.length(); j++){
                last = j - 1;
                if(str.charAt(i) == str.charAt(j)) {
                    count++;
                    last++;
                }
                else {
                    break;
                }
            }

            //count 값 넣기
            if(count == 1) sb.append(str.charAt(i));
            else sb.append(str.charAt(i)).append(count);

            i = last;
        }

        System.out.println(sb);
    }
}
