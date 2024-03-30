import java.util.*;

public class Main{
	public static void solution(int N, int[] arr){
		ArrayList<Integer> sosu = new ArrayList<Integer>();
		for(int i = 0; i < 100000 - 1; i++){
			sosu.add(i+2);
		}
		for(int i = 0; i < 100000 - 1; i++){
			if(sosu.get(i) == 0) continue;
			if(sosu.get(i) > 100) continue;
			for(int j = i + 1; j < 100000 - 1; j++){
				if(sosu.get(j) == 0) continue;
				if(sosu.get(j)%sosu.get(i) == 0) sosu.set(j, 0);
			}
		}

		for(int i = 0; i < N; i++){
			if(sosu.contains(arr[i])){
				System.out.print(arr[i] + " ");
			}
		}

	}
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++){
			String str = kb.next();
			String temp = "";
			for(int j = 0; j < str.length(); j++){
				temp += str.charAt(str.length() - 1 - j);
			}
			arr[i] = Integer.parseInt(temp);
		}
		solution(N, arr);
	}
}