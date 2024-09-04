import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Set<String> setarr = new HashSet<String>();
        for(int i = 0; i < N; i++){
            setarr.add(br.readLine());
        }

        String[] arr = setarr.toArray(new String[setarr.size()]);
        Arrays.sort(arr, (e1, e2) ->{
            if(e1.length() == e2.length()){
                return e1.compareTo(e2);
            }
            else return e1.length() - e2.length();
        });

        for(int i = 0; i < setarr.size(); i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}