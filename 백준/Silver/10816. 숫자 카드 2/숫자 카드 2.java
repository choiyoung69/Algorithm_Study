import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        String str;
        int number;
        for(int i = 0; i < N; i++){
            str = st.nextToken();
            if(map.get(str) == null){
                map.put(str, 1);
            }else{
                number = map.get(str);
                map.put(str, ++number);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            str= st.nextToken();
            if(map.get(str) == null) sb.append("0 ");
            else sb.append(map.get(str)).append(' ');
        }

        System.out.println(sb);
    }
}