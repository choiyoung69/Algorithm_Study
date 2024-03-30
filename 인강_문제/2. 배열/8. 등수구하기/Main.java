import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++){
			String temp = kb.next();
			arr[i] = Integer.parseInt(temp);
		}

		solution(N, arr);
	}
	public static void solution(int N, int[] arr){
		int[] sort_arr = new int[N];
		int[] rank = new int[N];
		int count = 1;

		for(int i = 0; i < N; i++){
			sort_arr[i] = arr[i];
		}

		for(int i = 0; i < sort_arr.length - 1; i++){
			for(int j = 0; j < sort_arr.length - 1 - i; j++){
				if(sort_arr[j] < sort_arr[j+1]){
					int temp = sort_arr[j];
					sort_arr[j] = sort_arr[j + 1];
					sort_arr[j + 1] = temp;
				}
			}
		}
		List<Integer> sort_list = new ArrayList<Integer>();

		for(int i = 0; i < N; i++){
			sort_list.add(sort_arr[i]);
		}

		//rank를 저장할 배열 생성(같은 등수를 처리하기 위해서 count 변수 생성)
		rank[0] = count;
		for(int i = 1; i < sort_arr.length; i++){
			count++;
			if(sort_arr[i - 1] == sort_arr[i]){
				rank[i] = rank[i - 1];
			}
			else{
				rank[i] = count;
			}
		}

		for(int i = 0; i < N; i++){
			System.out.print(rank[sort_list.indexOf(arr[i])] + " ");
		}

	}
}