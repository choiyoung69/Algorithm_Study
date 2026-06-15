import java.util.*;

class Pieces {
    private List<List<int[]>> pieces;
    private boolean isUsed;
    
    public Pieces(List<List<int[]>> pieces, boolean isUsed) {
        this.pieces = pieces;
        this.isUsed = isUsed;
    }
    
    public boolean isVisited() {
        return isUsed;
    }
    
    public List<List<int[]>> getPieces(){
        return pieces;
    }
    
    public void use() {
        this.isUsed = true;
    }
}

class Solution {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private boolean[][] visitedTable; 
    private boolean[][] visitedBoard; 
    private List<Pieces> cubeLists = new ArrayList<>();
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        int tableSize = table.length;
        visitedTable = new boolean[tableSize][tableSize];
        
        for(int i = 0; i < tableSize; i++) {
            for(int j = 0; j < tableSize; j++) {
                if(visitedTable[i][j]) continue;
                if (table[i][j] == 0) continue;
                
                List<int[]> points = new ArrayList<>();
                dfs(j, i, tableSize, table, points, visitedTable, 1);
            
                cubeLists.add(new Pieces(array(points), false));
            }
        }
        
        int boardSize = game_board.length;
        visitedBoard = new boolean[boardSize][boardSize];
        for(int i = 0; i < tableSize; i++) {
            for(int j = 0; j < tableSize; j++) {
                if(visitedBoard[i][j]) continue;
                if (game_board[i][j] == 1) continue;
                
                List<int[]> points = new ArrayList<>();
            
                dfs(j, i, boardSize, game_board, points, visitedBoard, 0);
                
                List<int[]> result = normalize(points);
                
                boolean matched = false;

                for (Pieces piece : cubeLists) {
                    if (piece.isVisited()) continue;

                    for (List<int[]> rotated : piece.getPieces()) {
                        if (isSame(result, rotated)) {
                            piece.use();
                            answer += result.size();
                            matched = true;
                            break;
                        }
                    }

                    if (matched) break;
                }
            }
        }
        
        return answer;
    }
    
    public void dfs(int x, int y, int tableSize, int[][] table, List<int[]> points, boolean[][] visited, int target) {
        points.add(new int[]{y, x});
        visited[y][x] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= tableSize || ny < 0 || ny >= tableSize) continue;
            if(visited[ny][nx]) continue;
            if(table[ny][nx] != target) continue;
            dfs(nx, ny, tableSize, table, points, visited, target);
        }
    }    

    public List<List<int[]>> array(List<int[]> points){
        List<List<int[]>> result = new ArrayList<>();
        
        List<int[]> current = normalize(points);
        
        result.add(current);
        
        for (int i = 0; i < 3; i++) {
            List<int[]> rotated = new ArrayList<>();

            for (int[] point : current) {
                int row = point[0];
                int col = point[1];

                rotated.add(new int[]{col, -row});
            }

            current = normalize(rotated);
            result.add(current);
        }

        return result;
    }
    
    public List<int[]> normalize(List<int[]> points) {
        List<int[]> result = new ArrayList<>();
        
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        
        for(int[] point : points) {
            minRow = Math.min(minRow, point[0]);
            minCol = Math.min(minCol, point[1]);
        }
        
        for(int[] point : points) {
            result.add(new int[]{
                point[0] - minRow,
                point[1] - minCol
            });
        }
        
        result.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }       
            return a[1] - b[1];
        });
        return result;
    }
    
    private boolean isSame(List<int[]> a, List<int[]> b) {
        if (a.size() != b.size()) return false;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0]) return false;
            if (a.get(i)[1] != b.get(i)[1]) return false;
        }

        return true;
    }
}