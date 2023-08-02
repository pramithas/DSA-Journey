package maths;

public class Sieve {

    static void sieve(int n, boolean[] primes){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(!primes[i]){
                primes[i] = false;
                for (int j = i*2; j <= n; j+=i) {
                    primes[j] = true;
                }
            }
        }
        for (int x = 2; x < n; x++) {
            if(primes[x] == false){
                System.out.println(x);
            }
        }
    }

    public static void main(String[] args) {
        int n = 100;
        boolean[] primes = new boolean[n+1];
        sieve(n, primes);
    }
}
