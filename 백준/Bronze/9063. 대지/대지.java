import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line;

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        int result = 0;

        for(int i = 0; i < N; i++){
            line = br.readLine().split(" ");

            x.add(Integer.parseInt(line[0]));
            y.add(Integer.parseInt(line[1]));
        }

        result = (Collections.max(x) - Collections.min(x)) * (Collections.max(y) - Collections.min(y));

        System.out.println(result);
    }
}