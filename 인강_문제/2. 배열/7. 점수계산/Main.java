import java.util.*;

public class Main{
	public static int solution(int length, int[] arr){
		int check = 0;
		int answer = 0;

		for(int i = 0; i < arr.length; i++){
			answer += check + arr[i];
			if(i == arr.length - 1) break;
			if(arr[i] == 1){
				if(arr[i + 1] == 0) check = 0;
				else check += 1;
			}
		}
		return answer;

	}
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int length = kb.nextInt();
		int[] arr = new int[length];
		for(int i = 0; i < length; i++){
			arr[i] = kb.nextInt();
		}

		System.out.println(solution(length, arr));
	}
}