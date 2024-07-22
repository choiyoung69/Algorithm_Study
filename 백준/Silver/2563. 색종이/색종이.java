import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        boolean[][] arr = new boolean[100][100];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for(int j = x; j < x + 10; j++){
                for(int k = y; k < y+10; k++){
                    arr[j][k] = true;
                }
            }
            sc.nextLine();
        }
        int area = 0;

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(arr[i][j]) area++;
            }
        }
        System.out.println(area);
    }
}