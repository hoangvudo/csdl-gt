package Dequy;

public class baiKhuDeQuy {

    // Tính giai thừa của n
    public int gthua(int n) {
        int i, gt = 1;
        if (n == 0) return 1; // Giai thừa của 0 là 1
        else {
            for (i = 1; i <= n; i++) gt = gt * i;
            return gt;
        }
    }

    // Tính số Fibonacci thứ n không dùng đệ quy
    public int Fibo(int n) {
        if (n == 1 || n == 2) return 1; // Số Fibonacci đầu tiên
        int f1 = 1, f2 = 1, f = f1 + f2;
        for (int i = 3; i <= n; i++) {
            f1 = f2;
            f2 = f;
            f = f1 + f2;
        }
        return f;
    }

    // Tính giai thừa không dùng đệ quy (vòng lặp)
    public int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Tính lũy thừa không dùng đệ quy
    public int power(int x, int n) {
        int result = 1;
        while (n > 0) {
            if (n % 2 == 1) { // Nếu n lẻ
                result *= x;
            }
            x *= x; // Bình phương x
            n /= 2; // Chia đôi n
        }
        return result;
    }

    // Tính tổng từ 1 đến n không dùng đệ quy
    public int sum(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }

    // Tính số lượng chữ số của một số nguyên dương n không dùng đệ quy
    public int countDigits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10; // Chia n cho 10
        }
        return count;
    }

    // Kiểm tra số nguyên dương n có phải là số nguyên tố không dùng đệ quy
    public boolean isPrime(int n) {
        if (n < 2) return false; // Số nguyên tố bắt đầu từ 2
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false; // Nếu n chia hết cho i thì không phải là số nguyên tố
        }
        return true;
    }

    // Tính số lượng số nguyên tố nhỏ hơn n không dùng đệ quy
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }
}
