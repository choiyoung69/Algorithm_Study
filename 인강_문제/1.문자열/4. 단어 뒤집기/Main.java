import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		int Nlength = 0;
		int count = 0;

		Scanner sc = new Scanner(System.in);
		Nlength = Integer.parseInt(sc.nextLine());
		String[] strArr = new String[Nlength];

		while(sc.hasNextLine()){
			strArr[count] = sc.nextLine();
			count++;
		}
		for(int i = 0; i < Nlength; i++){
			String temp = "";
			for(int j = 0; j < strArr[i].length(); j++){
				temp += strArr[i].charAt(strArr[i].length() - j - 1);
			}
			strArr[i] = temp;
		}
		for(int i = 0; i < Nlength; i++){
			System.out.println(strArr[i]);
		}
	}
}