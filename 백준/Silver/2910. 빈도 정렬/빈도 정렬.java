import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x;
    int count;
}

class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> m = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            int count = m.getOrDefault(x, 0);
            m.put(x, count + 1);
        }

        List<Node> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> mp : m.entrySet()) {
            Node n = new Node();
            n.x = mp.getKey();
            n.count = mp.getValue();
            arr.add(n);
        }

        Collections.sort(arr, new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.count == o2.count) {
                    return 0;
                }
                else return o2.count - o1.count;
            }
        });

        for (Node n : arr) {
            for (int i = 0; i < n.count; i++) {
                System.out.print(n.x + " ");
            }
        }
    }
}
