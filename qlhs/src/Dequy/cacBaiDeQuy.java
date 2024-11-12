package Dequy;

public class cacBaiDeQuy {
    // Chuyển số nguyên n sang hệ nhị phân
    public void chuyenNP(int n) {
        if (n != 0) {
            chuyenNP(n / 2);
            System.out.print(n % 2);
        }
    }

    // Tính số Fibonacci thứ n bằng đệ quy
    public int f(int n) {
        if (n == 1 || n == 2) return 1;
        else return f(n - 1) + f(n - 2);
    }

    // Tính giai thừa của n bằng đệ quy
    public int gthua(int n) {
        if (n == 0) return 1;
        else return n * gthua(n - 1);
    }

    // Tìm UCLN của a và b bằng đệ quy
    public int us(int a, int b) {
        if (a == b) return a;
        else if (a > b) return us(a - b, b);
        else return us(a, b - a);
    }

    // Tính tổng các số từ 1 đến n bằng đệ quy
    public int tong(int n) {
        if (n == 1) return 1;
        else return n + tong(n - 1);
    }

    // Đệ quy giải bài toán N-Queen
    public void quayLui(int n) {
        int[] x = new int[n];
        xepHau(x, 0, n);
    }

    private boolean anToan(int[] x, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (x[i] == col || Math.abs(x[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private void xepHau(int[] x, int row, int n) {
        if (row == n) {
            inKetQua(x, n);
        } else {
            for (int col = 0; col < n; col++) {
                if (anToan(x, row, col)) {
                    x[row] = col;
                    xepHau(x, row + 1, n);
                }
            }
        }
    }

    private void inKetQua(int[] x, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (x[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Tính tổng các chữ số của số nguyên n bằng đệ quy
    public int sumDigits(int n) {
        if (n == 0) return 0;
        return n % 10 + sumDigits(n / 10);
    }


    // Hàm Sắp xếp nổi bọt (Bubble Sort)
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Hoán đổi arr[j] và arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Mảng sau khi sắp xếp nổi bọt:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Hàm Sắp xếp chọn (Selection Sort)
    public void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Hoán đổi arr[i] và arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println("Mảng sau khi sắp xếp chọn:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
 // Hàm QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

