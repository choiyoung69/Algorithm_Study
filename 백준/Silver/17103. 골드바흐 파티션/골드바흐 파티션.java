import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main{
    public static boolean[] arrList = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        get_prime();

        int N = Integer.parseInt(br.readLine());
        int count;
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            count = 0;
            for(int j = 1; j <= k/2; j++){
                if(!arrList[j] && !arrList[k - j]) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static public void get_prime(){
        arrList[0] = true;
        arrList[1] = true;
        int end = arrList.length;
        for(int i = 2; i <= Math.sqrt(end); i++){
            if(arrList[i]) continue;
            for (int j = i * i; j <= end - 1; j += i) {
                arrList[j] = true;
            }
        }
    }
}