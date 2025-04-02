import java.io.*;
import java.util.*;

class Body implements Comparable<Body> {
    int h, w;

    public Body(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Body o) {
        return o.h - this.h;
    }
}

public class Main { ;
    public int solution(ArrayList<Body> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;

        for (Body ob : arr) {
            if(ob.w > max) {
                max = ob.w;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Body> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr.add(new Body(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        System.out.println(T.solution(arr, N));
    }
}
