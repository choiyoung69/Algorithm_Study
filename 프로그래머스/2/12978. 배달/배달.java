import java.util.*;

class Node {
    int name;
    int length;
    
    public Node(int name, int length) {
        this.name = name;
        this.length = length;
    }
}

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        distance[1] = 0;
        
        Map<Integer, List<Node>> maps = new HashMap<>();
        
        for (int[] oneRoad : road) {
            int from = oneRoad[0];
            int to = oneRoad[1];
            int length = oneRoad[2];

            maps.computeIfAbsent(from, key -> new ArrayList<>())
                .add(new Node(to, length));

            maps.computeIfAbsent(to, key -> new ArrayList<>())
                .add(new Node(from, length));
        }

        dfs(maps, 1, distance, 0, K);
        
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    private void dfs(Map<Integer, List<Node>> maps, int now, 
                     int[] distance, int sum, int K) {
        
        List<Node> list = maps.get(now);
        
        if (list == null) return;
        
        for(Node node : list) {
            int newDistance = sum + node.length;

            if (newDistance <= K && newDistance < distance[node.name]) {
                distance[node.name] = newDistance;

                dfs(maps, node.name, distance, newDistance, K);
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
}