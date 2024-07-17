import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[][] arr = new String[5][];

        for(int i = 0; i < 5; i++){
            arr[i] = Arrays.stream(sc.nextLine().split(""))
                        .map(String::trim)
                        .toArray(String[]::new);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 5; j++){
                if(arr[j].length <= i) continue;
                sb.append(arr[j][i]);
            }
        }

        System.out.print(sb.toString());
    }
}