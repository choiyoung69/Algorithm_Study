import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            if(i < str.length() - 1 && (str.substring(i, i + 2).equals("pi") || str.substring(i, i + 2).equals("ka"))) i+= 1;
            else if(i < str.length() - 2 && str.substring(i, i + 3).equals("chu")) i+= 2;
            else flag = true;
        }

        if (flag) System.out.println("NO");
        else System.out.println("YES");
    }
}
