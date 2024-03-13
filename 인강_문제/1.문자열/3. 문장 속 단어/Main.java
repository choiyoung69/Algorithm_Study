import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		String[] strArr;
		int maxIndex = 0;
		int max = 0;

		Scanner sc =new Scanner(System.in);
		String temp = sc.nextLine();

		strArr = temp.split(" ");
		for(int i = 0; i < strArr.length; i++){
			if(strArr[i].length() > max){
				max = strArr[i].length();
				maxIndex = i;
			}
		}
		System.out.print(strArr[maxIndex]);
	}
}