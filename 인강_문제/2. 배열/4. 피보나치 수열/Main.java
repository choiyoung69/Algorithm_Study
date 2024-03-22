import java.util.Scanner;

public class Main{
	public static void solution(int n){
		int a = 1;
		int b = 1;

		System.out.print("1 ");
		System.out.print("1 ");
		for(int i = 2; i < n; i++){
			int c = a + b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}
	}
	public static void main(String[] args){
		
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();

		solution(n);
	}
}