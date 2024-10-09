public class CircularPrimes {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isCircularPrime(int n) {
        String str = String.valueOf(n);
        for (int i = 0; i < str.length(); i++) {
            String rotated = str.substring(i) + str.substring(0, i);
            int rotatedNum = Integer.parseInt(rotated);
            if (!isPrime(rotatedNum)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 2; i <= 10000; i++) {
            if (isCircularPrime(i)) {
                System.out.println(i);
            }
        }
    }
}
