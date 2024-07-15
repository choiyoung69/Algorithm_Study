import java.util.*;

class Main {
    public static int solution(int count, String[] arr) {
        int result = 0;
        for (int i = 0; i < count; i++) {
            int j = 0;
            while (true) {
                if (j == arr[i].length() - 1) {
                    result++;
                    break;
                }
                if (arr[i].charAt(j) != arr[i].charAt(j + 1)) {
                    char ch = arr[i].charAt(j);
                    arr[i] = arr[i].substring(j + 1);
                    j = 0;
                    if (arr[i].contains(Character.toString(ch))) break;
                    continue;
                }
                j++;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String[] arr = new String[count];

        for(int i = 0; i < count; i++) {
            arr[i] = sc.nextLine();
        }
        System.out.println(solution(count, arr));
    }
}