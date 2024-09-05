import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        String name;
        String enterOrLeave;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            enterOrLeave = st.nextToken();

            if(enterOrLeave.equals("enter")) set.add(name);
            else if(enterOrLeave.equals("leave")) set.remove(name);
        }

        ArrayList<String> tmp = new ArrayList<>(set);
        tmp.sort(Collections.reverseOrder());

        for(String str : tmp){
            sb.append(str).append("\n");
        }
        System.out.println(sb);

    }
}