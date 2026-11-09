class Solution {
    
    
    private int fibonachi(int[] visited, int n) {
        if(n == 0 || visited[n] != 0) {
            return visited[n];
        }
        
        return visited[n] = (fibonachi(visited, n - 1) + fibonachi(visited, n - 2)) % 1234567;
    }
    
    
    public int solution(int n) {
        int[] visited = new int[100004];
        int now = 2;
        
        visited[0] = 0;
        visited[1] = 1;
        
        return fibonachi(visited, n);
    }
}