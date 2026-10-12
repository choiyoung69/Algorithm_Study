import java.util.*;

class Solution {
    private boolean isPrime(int n) {
        if(n < 2) return false;
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }

    private void getPrimes(int acc, List<Integer> numbers, Set<Integer> primes){
        if(isPrime(acc)) {
            primes.add(acc);
        }
        
        for(int i = 0; i < numbers.size(); i++) {
            int nextAcc = 10 * acc + numbers.get(i);
            List<Integer> nextNumbers = new ArrayList<>(numbers);
            nextNumbers.remove(i);
            getPrimes(nextAcc, nextNumbers, primes);
        }
    }
    
    public int solution(String numbers) {
        List<Integer> numbersList = new ArrayList<>();
        
        for(char number : numbers.toCharArray()) {
            numbersList.add(number - '0');
        }
        
        Set<Integer> primes = new HashSet();
        getPrimes(0, numbersList, primes);
        
        return primes.size();
    }
}