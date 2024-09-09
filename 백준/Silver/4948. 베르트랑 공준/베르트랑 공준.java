import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> arr = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        while(N != 0){
            arr.add(N);
            N = Integer.parseInt(br.readLine());
        }

        int max = Collections.max(arr);


        boolean[] arrList = new boolean[2 * max + 1];

        arrList[0] = true;
        arrList[1] = true;

        int end = max * 2;
        for(int i = 2; i <= Math.sqrt(end); i++){
            if(arrList[i]) continue;
            for (int j = i * i; j <= end; j += i) {
                arrList[j] = true;
            }
        }

        int count = 0;
        for (int number : arr) {
            count = 0;
            for(int j = number+ 1; j <= number*2; j++){
                if(!arrList[j]) count++;
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}