import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> arr = new ArrayList<>();
        String str = br.readLine();
        while (!str.equals("end")) {
            arr.add(str);
            str = br.readLine();
        }

        for (String s : arr) {
            boolean flag = false;
            int vcnt = 0, lcnt = 0;
            char prev = '0';

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    flag = true;
                    vcnt = 0;
                    lcnt += 1;
                }
                else{
                    vcnt++;
                    lcnt = 0;
                }

                if (prev == ch && ch != 'e' && ch != 'o') {
                    flag = false;
                    break;
                }

                if (lcnt == 3 || vcnt == 3) {
                    flag = false;
                    break;
                }
                prev = ch;
            }

            if (flag) {
                System.out.println("<" + s + "> is acceptable.");
            } else {
                System.out.println("<" + s + "> is not acceptable.");
            }
        }
    }
}
