import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static String convertTime(int time) {
        String minute = "00" + Integer.toString(time / 60);
        String second = "00" + Integer.toString(time % 60);

        return minute.substring(minute.length() - 2) + ":" + second.substring(second.length() - 2);
    }

    public static int addPrevValue(String prev, String now, int time) {
        time += Integer.parseInt(now.substring(0,2))*60 + Integer.parseInt(now.substring(3))
                - Integer.parseInt(prev.substring(0,2))*60 - Integer.parseInt(prev.substring(3));
        return time;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt_1 = 0, cnt_2 = 0, time_1 = 0, time_2 = 0;
        String prev = "";

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            if(cnt_1 > cnt_2) time_1 = addPrevValue(prev, s, time_1);
            else if(cnt_1 < cnt_2) time_2 = addPrevValue(prev, s, time_2);

            if(o == 1) cnt_1++;
            else cnt_2++;
            prev = s;
        }

        if(cnt_1 > cnt_2) time_1 = addPrevValue(prev, "48:00", time_1);
        else if(cnt_1 < cnt_2) time_2 = addPrevValue(prev, "48:00", time_2);

        System.out.println(convertTime(time_1));
        System.out.println(convertTime(time_2));
    }
}
