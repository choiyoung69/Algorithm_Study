import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public Point[] solution(int N, Point[] arr) {
        Arrays.sort(arr, new Comparator<Point>(){
            public int compare(Point p1, Point p2){
                if(p1.x == p2.x){
                    return p1.y - p2.y;
                }
                else return p1.x - p2.x;
            }
        });

        return arr;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Point[] parr = new Point[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            parr[i] = new Point(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        for(Point x : main.solution(N, parr)){
            System.out.println(x.x + " " + x.y);
        }
    }
}
