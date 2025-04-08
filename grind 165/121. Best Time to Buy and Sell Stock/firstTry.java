//처음 보자마자 투 포인터라고 감이 딱 옴
//내가 푼 풀이
class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int a = 0;

        for(int b = 0; b < prices.length; b++) {
            if(prices[a] <= prices[b]) {
                answer = Math.max(answer, prices[b] - prices[a]);
            }
            else {
                while(prices[a] > prices[b]) {
                    a++;
                }
            }
        }

        return answer;
    }
}

//soluton1
class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int minValue = prices[0];

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < minValue) {
                minValue = prices[i];
            }
            else if(prices[i] - minValue > answer) {
                answer = prices[i] - minValue;
            }
        }

        return answer;
    }
}

//solution2
//비슷하지만 살짝 다른 코드
class Solution {
    public int maxProfit(int[] prices) {
        int maxValue = 0;
        int min = Integer.MAX_VALUE;

        for(int price : prices) {
            min = Math.min(min, price);
            maxValue = Math.max(maxValue, price - min);
        }
        return maxValue;
    }
}
