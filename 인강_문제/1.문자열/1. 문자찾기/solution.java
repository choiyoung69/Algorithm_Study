import java.util.*;

class Main{
	public int solution(String str, char t){
		int answer = 0;

		str = str.toUpperCase();
		t = Character.toUpperCase(t);

		for(char x : str.toCharArray()){
			if(x == t) answer++;
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();

		//입력받은 문자열
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		char c = kb.next().charAt(0);

		System.out.print(T.solution(str, c));
	}
}