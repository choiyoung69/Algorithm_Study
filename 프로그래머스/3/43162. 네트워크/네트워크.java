class Solution {
    private static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int now, int n, int[][] computers) {
        visited[now] = true;

        for (int next = 0; next < n; next++) {
            if (computers[now][next] == 0) continue;
            if (visited[next]) continue;
            dfs(next, n, computers);
        }
    }
}