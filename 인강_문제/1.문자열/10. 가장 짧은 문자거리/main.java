import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] str_arr = st.nextToken().toCharArray();
        char goal = st.nextToken().charAt(0);
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < str_arr.length; i++){
            if(str_arr[i] == goal) arr.add(i);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < arr.get(0); i++){
            answer.add(arr.get(0) - i);
        }

        for(int i = 0; i < arr.size() - 1; i++){
            int a = arr.get(i + 1) - arr.get(i);

            int k;
            if(a % 2 == 0) k = a/2 - 1;
            else k = a/2;

            for(int j = 0; j <= a/2; j++){
                answer.add(j);
            }
            for(int j = k; j > 0; j--){
                answer.add(j);
            }
        }

        int count = 0;
        for(int i = arr.get(arr.size() - 1); i < str_arr.length; i++){
            answer.add(count);
            count++;
        }

        for(int k : answer){
            sb.append(k).append(" ");
        }
        System.out.println(sb);
    }
}
