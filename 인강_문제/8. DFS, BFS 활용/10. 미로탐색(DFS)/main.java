import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    int[] temp = {-1, 1, -1, 1};
    public void DFS(int x, int y, int[][] arr) {
        if(x == 6 && y == 6) {
            count++;
        }
        else {
            for(int i = 0; i < 4; i++){
                int nx, ny;
                if(i < 2) {
                    nx = x + temp[i];
                    ny = y;
                }
                else {
                    nx = x;
                    ny = y + temp[i];
                }
                if(nx < 0 || nx >= 7 || ny < 0 || ny >= 7) continue;
                if(arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    DFS(nx, ny, arr);
                    arr[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[7][7];
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        arr[0][0] = 1;
        T.DFS(0, 0, arr);
        System.out.println(count);
    }
}
