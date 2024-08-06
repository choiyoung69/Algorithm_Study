import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder  sb = new StringBuilder();

        while(true) {
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            int[] arr = {Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())};

            //while문 빠져나가는 조건
            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;

            Arrays.sort(arr);
            if(arr[2] >= (arr[0] + arr[1])) sb.append("Invalid\n");
            else if(arr[0] == arr[1] && arr[1] == arr[2]) sb.append("Equilateral\n");
            else if(arr[0] != arr[1] && arr[1] != arr[2] && arr[0] != arr[2]) sb.append("Scalene\n");
            else sb.append("Isosceles\n");
        }

        System.out.println(sb);
    }
}