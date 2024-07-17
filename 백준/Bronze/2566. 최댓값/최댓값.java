import java.util.*;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for(int i = 0; i < 9; i++){
            arr[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }
        List<Integer> list = Arrays.stream(arr)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());

        int max = Collections.max(list);
        int idx = list.indexOf(max);
        System.out.println(max);
        System.out.print((idx/9+1) + " " + (idx%9+1));
    }
}