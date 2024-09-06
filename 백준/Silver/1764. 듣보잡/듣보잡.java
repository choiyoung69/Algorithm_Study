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

        Set<String> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            set.add(br.readLine());
        }

        ArrayList<String> name = new ArrayList<>();
        for(int i = 0; i < M; i++){
            String tmp = br.readLine();
            if (set.contains(tmp)) {
                name.add(tmp);
            }
        }

        sb.append(name.size()).append("\n");
        Collections.sort(name);
        for(int i = 0; i < name.size(); i++){
            sb.append(name.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}