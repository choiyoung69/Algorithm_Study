import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int i = 666;
        while (N != 0) {
            if (Integer.toString(i).contains("666")) {
                N--;
            }
            i++;
        }
        System.out.println(i - 1);
    }
}
