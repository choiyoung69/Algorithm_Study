import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] rnt = new int[H][W];

        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            boolean flag = false;
            int cnt = 0;
            for (int j = 0; j < W; j++) {
                char ch = str.charAt(j);
                if(ch == '.' && !flag) rnt[i][j] = -1;
                else if (ch == 'c') {
                    rnt[i][j] = 0;
                    cnt = 0;
                    flag = true;
                } else {
                    cnt++;
                    rnt[i][j] = cnt;
                }
            }
        }

        for (int[] arr : rnt) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
