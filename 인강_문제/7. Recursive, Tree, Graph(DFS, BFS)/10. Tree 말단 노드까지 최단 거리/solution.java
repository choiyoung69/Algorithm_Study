import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int data;
    Node lt, rt;
    public Node(int val){
        this.data =val;
        lt=rt=null;
    }
}

public class Main {
    Node root;

    public int BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while(!Q.isEmpty()){
            int size = Q.size();
            for(int i = 0; i < size; i++){
                Node temp = Q.poll();
                if(temp.lt == null && temp.rt == null) return L;
                if(temp.lt != null) Q.offer(temp.lt);
                if(temp.rt != null) Q.offer(temp.rt);
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        System.out.println(T.BFS(T.root));
    }
}
