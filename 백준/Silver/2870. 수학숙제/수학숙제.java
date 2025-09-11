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

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (Character.isDigit(ch)) {
                    sb.append(ch);
                }
                else if(sb.length() > 0) {
                    rnt.add(removeLeadingZero(sb.toString()));
                    sb = new StringBuilder();
                }
            }

            if(sb.length() > 0) {
                rnt.add(removeLeadingZero(sb.toString()));
            }
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

    private static String removeLeadingZero(String s) {
        int idx = 0;

        while (idx < s.length() - 1 && s.charAt(idx) == '0') {
            idx++;
        }
        return s.substring(idx);
    }
}