class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int discount_n = 0;
        
        discount_n = n/10;
        answer = 12000*n + (k-discount_n)*2000;
        
        return answer;
    }
}