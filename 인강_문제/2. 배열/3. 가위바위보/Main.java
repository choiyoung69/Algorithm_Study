import java.util.Scanner;

public class Main{
	public static void solution(int n, int[] arrA,int[] arrB){
		for(int i = 0; i < n; i++){
			if(arrA[i] == 3 && arrB[i] == 1){
				System.out.println("B");
				continue;
			}
			if(arrA[i] == 1 && arrB[i] == 3){
				System.out.println("A");
				continue;
			}
			if(arrA[i] > arrB[i]) System.out.println("A");
			else if(arrA[i] == arrB[i]) System.out.println("D");
			else System.out.println("B");


		}
	}
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arrA = new int[n];
		int[] arrB = new int[n];
		for(int i = 0; i < n; i++){
			arrA[i] = kb.nextInt();
		}
		for(int i = 0; i < n; i++){
			arrB[i] = kb.nextInt();
		}
		solution(n, arrA, arrB);
	}
}