import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.y != o.y) {
            return this.y - o.y;
        }
        else {
            return this.x - o.x;
        }
    }
}

public class Main { ;
    public int solution(ArrayList<Point> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);
        int end = -1;

        for (int i = 0; i < n; i++) {
            if(arr.get(i).x >= end) {
                cnt++;
                end = arr.get(i).y;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        System.out.println(T.solution(arr, N));
    }
}
