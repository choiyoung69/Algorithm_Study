import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str;
        int max = 0;
        String result = "";

        while(st.hasMoreTokens()){
            str = st.nextToken();

            if(max < str.length()) {
                max = str.length();
                result = str;
            }
        }

        System.out.println(result);
    }
}
