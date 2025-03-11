import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt=rt=null;
    }
}

public class Main {
    static int n;
    static int[] ch; // 체크 배열

    public void DFS(int L) {
        if(L == n+1) {
            String tmp = "";
            for(int i = 1; i<= n; i++){
                if(ch[i] == 1) tmp += (i + " ");
            }
            if(tmp.length() > 0) System.out.println(tmp);
        }
        else{
            ch[L] = 1;
            DFS(L+1);
            ch[L] = 0;
            DFS(L+1);
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        n = 3;
        ch = new int[n+1];
        tree.DFS(1);
    }
}
