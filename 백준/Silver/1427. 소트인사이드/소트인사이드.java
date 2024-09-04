import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        int[] counting = new int[10];

        for(int i = 0; i < str.length(); i++){
           counting[(int)(str.charAt(i) - '0')]++;
        }

        for(int i = 9; i >= 0; i--){
            while(counting[i] > 0){
                sb.append(i);
                counting[i]--;
            }
        }
        System.out.println(sb);
    }
}