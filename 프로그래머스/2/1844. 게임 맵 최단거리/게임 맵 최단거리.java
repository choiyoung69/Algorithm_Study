import java.util.*;

class Point{
    int x;
    int y;
    int dist;
    
    Point(int y, int x, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {
    private static int N;
    private static int M;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        boolean[][] visited = new boolean[N][M];
        Queue<Point> queue = new LinkedList();
        queue.add(new Point(0, 0, 1));
        
        int count = 0;
        while(queue.size() != 0) {
            Point p = queue.poll();
            
            if (p.y == N - 1 && p.x == M - 1) {
                return p.dist;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (visited[ny][nx]) continue;
                if (maps[ny][nx] == 0) continue;
                
                visited[ny][nx] = true;
                queue.add(new Point(ny, nx, p.dist + 1));
            }
        }
        
        return -1;
    }
}