import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int n = sc.nextInt();
            if(n == -1) break;

            List<Integer> arr = new ArrayList<>();
            for(int i = 1; i < n; i++){
                if(n%i == 0) arr.add(i);
            }

            int total = 0;
            for (int i : arr) {
                total += i;
            }

            if(n == total) {
                StringBuilder sb = new StringBuilder();
                sb.append(n);
                sb.append(" = ");
                for (int i = 0; i < arr.size(); i++) {
                    sb.append(arr.get(i));
                    if (i < arr.size() - 1) {
                        sb.append(" + ");
                    }
                }
                System.out.println(sb.toString());
            }
            else{
                System.out.println(n + " is NOT perfect.");
            }

        }
    }
}