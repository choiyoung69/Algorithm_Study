import java.util.*;

public class Main{
	public static void solution(int N){
		int count = 0;
		int[] arr = new int[N - 1];
		for(int i = 0; i < arr.length; i++){
			arr[i] = i + 2;
		}
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == 0) continue;
			count++;
			if(arr[i] > Math.sqrt(N)) continue;
			for(int j = i + 1; j < arr.length; j++){
				//0을 나누면 에러 발생하므로 0이면 지나쳐야 한다.
				if(arr[j] == 0) continue;
				if(arr[j]%arr[i] == 0) arr[j] = 0;
			}
		}
		System.out.println(count);
	}
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		solution(N);
		return;
	}
}