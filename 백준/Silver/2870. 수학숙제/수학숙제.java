import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> rnt = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();

            int j = 0;
            for (j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (Character.isDigit(ch)) {
                    sb.append(ch);
                }
                else if(sb.length() > 0) {
                    getStringBuilder(sb, rnt);
                    sb = new StringBuilder();
                }
            }
            if(j == str.length() && sb.length() > 0) {
                getStringBuilder(sb, rnt);
            }
            sb = new StringBuilder();
        }

        Collections.sort(rnt, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return Integer.compare(o1.length(), o2.length());
            }
        });

        for (String x : rnt) {
            System.out.println(x);
        }
    }

    private static void getStringBuilder(StringBuilder sb, List<String> rnt) {
        String s = sb.toString();
        StringBuilder temp_sb = new StringBuilder();
        boolean flag = false;
        for (int j = 0; j < s.length(); j++) {
            char temp_ch = s.charAt(j);
            if (temp_ch == '0' && !flag && j == s.length() - 1) {
                sb.append('0');
            } else if (temp_ch == '0' && !flag) continue;
            flag = true;
            temp_sb.append(s.charAt(j));
        }
        if(temp_sb.length() > 0) rnt.add(temp_sb.toString());
    }
}