class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        float num3 = (float)num1/num2;
        answer =(int)(num3*1000);
        return answer;
    }
}

class Solution1 {
    public int solution(int num1, int num2) {
        int answer = 0;
        return num1 * 1000 / num2;
    }
}
