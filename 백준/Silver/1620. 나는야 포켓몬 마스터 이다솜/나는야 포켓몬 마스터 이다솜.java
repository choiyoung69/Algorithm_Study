import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        String str;
        for(int i = 1; i <= N; i++){
            str = br.readLine();
            map1.put(str, i);
            map2.put(i, str);
        }

        for(int i = 0; i < M; i++){
            str = br.readLine();
            if(48 <= str.charAt(0) && str.charAt(0) <= 57){
                sb.append(map2.get(Integer.parseInt(str))).append("\n");
            }else{
                sb.append(map1.get(str)).append("\n");
            }
        }
        System.out.println(sb);
    }
}