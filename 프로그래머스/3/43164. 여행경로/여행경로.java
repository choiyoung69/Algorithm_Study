import java.util.*;

class Solution {
    private static List<String[]> routes = new ArrayList<>();
    private static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        visited = new boolean[tickets.length];
        String[] route = new String[tickets.length + 1];
        route[0] = "ICN";
        
        dfs(0, route, tickets);
        
        answer = routes.get(0);
        
        for (String[] r : routes) {
            if (compareRoute(r, answer) < 0) {
                answer = r;
            }
        }
        
        return answer;
    }
    
    private void dfs(int count, String[] route, String[][] tickets) {
        if(count == tickets.length) {
            routes.add(route);   
            return;
        }
        
        String now = route[count];
        
        for(int i = 0; i < tickets.length; i++){
            if(visited[i]) continue;
            
            String from = tickets[i][0];
            String to = tickets[i][1];
            
            if(!from.equals(now)) continue;
            
            visited[i] = true;
            
            route[count + 1] = to;
            dfs(count + 1, route.clone(), tickets);

            visited[i] = false;
        }
    }
    
    private int compareRoute(String[] a, String[] b) {
        for (int i = 0; i < a.length; i++) {
            int cmp = a[i].compareTo(b[i]);

            if (cmp != 0) {
                return cmp;
            }
        }

        return 0;
    }
}
