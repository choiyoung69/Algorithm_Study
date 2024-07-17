import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[][] narr = new int[n][m];
        int[][] marr = new int[n][m];

        for(int i = 0; i < 2*n; i++){
            if(i < n){
                narr[i] = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

            }else{
                marr[i - n] = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(narr[i][j] + marr[i][j] + " ");
            }
            System.out.println();
        }
    }
}