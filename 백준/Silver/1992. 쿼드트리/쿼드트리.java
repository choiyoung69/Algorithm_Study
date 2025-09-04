import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main
{
    private static int N;
    private static char[][] a;

    public static String go(int y, int x, int N) {
        if(N == 1){
            return String.valueOf(a[y][x]);
        }

        StringBuilder sb = new StringBuilder();

        String a = go(y, x, N/2);
        String b = go(y, x + N/2, N/2);
        String c = go(y + N/2, x, N/2);
        String d = go(y + N/2, x + N/2, N / 2);

        if (a.length() == 1 && a.equals(b) && a.equals(c) && a.equals(d)) {
            return a;
        }
        return sb.append("(").append(a).append(b).append(c).append(d).append(")").toString();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        a = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                a[i][j] = str.charAt(j);
            }
        }

        System.out.println(go(0, 0, N));
    }
}
