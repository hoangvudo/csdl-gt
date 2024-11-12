package Dequy;

import java.util.Scanner;

public class menuDeQuy {

    Scanner sc = new Scanner(System.in);
    cacBaiDeQuy deQuy = new cacBaiDeQuy();
    baiKhuDeQuy khuDQ = new baiKhuDeQuy();

    public void mainMenu() {
        int choice;
        do {
            System.out.println("\n╔═══════════════════════════════════╗");
            System.out.println("║            MENU CHÍNH               ║");
            System.out.println("╠═════════════════════════════════════╣");
            System.out.println("║ 1. Menu Đệ Quy                      ║");
            System.out.println("║ 2. Menu Khử Đệ Quy                  ║");
            System.out.println("║ 0. Thoát chương trình               ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.print("Mời bạn chọn (Nhập 0 để thoát): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    menuDQ();
                    break;
                case 2:
                    menuKhuDQ();
                    break;
                case 0:
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
        } while (choice != 0);
    }

    public void menuDQ() {
        int c1;
        do {
            System.out.println("\n╔═══════════════════════════════════════╗");
            System.out.println("║            MENU ĐỆ QUY                ║");
            System.out.println("╠═══════════════════════════════════════╣");
            System.out.println("║ 1. Đệ quy giai thừa                   ║");
            System.out.println("║ 2. Đệ quy Fibonacci                   ║");
            System.out.println("║ 3. Đệ quy tổng từ 1 đến n             ║");
            System.out.println("║ 4. Đệ quy tìm UCLN                    ║");
            System.out.println("║ 5. Đệ quy tổng các chữ số             ║");
            System.out.println("║ 6. Đệ quy chuyển số sang nhị phân     ║");
            System.out.println("║ 7. Đệ quy quay lui (N-Queen)          ║");
            System.out.println("║ 8. Sắp xếp nổi bọt                    ║");
            System.out.println("║ 9. Sắp xếp chọn                       ║");
            System.out.println("║ 10. Sắp xếp QuickSort                 ║");
            System.out.println("║ 0. Quay lại menu chính                ║");
            System.out.println("╚═══════════════════════════════════════╝");
            System.out.print("Mời bạn chọn: ");
            c1 = sc.nextInt();

            switch (c1) {
                case 1: {
                    System.out.print("Nhập số cần tính giai thừa: ");
                    int n = sc.nextInt();
                    System.out.println("Giai thừa của " + n + " là: " + deQuy.gthua(n));
                    break;
                }
                case 2: {
                    System.out.print("Nhập số Fibonacci cần tính: ");
                    int n = sc.nextInt();
                    System.out.println("Số hạng thứ " + n + " của Fibonacci là: " + deQuy.f(n));
                    break;
                }
                case 3: {
                    System.out.print("Nhập số cần tính tổng: ");
                    int n = sc.nextInt();
                    System.out.println("Tổng các số từ 1 đến " + n + " là: " + deQuy.tong(n));
                    break;
                }
                case 4: {
                    System.out.print("Nhập hai số cần tìm UCLN: ");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    System.out.println("UCLN của " + a + " và " + b + " là: " + deQuy.us(a, b));
                    break;
                }
                case 5: {
                    System.out.print("Nhập số cần tính tổng các chữ số: ");
                    int n = sc.nextInt();
                    System.out.println("Tổng các chữ số của " + n + " là: " + deQuy.sumDigits(n));
                    break;
                }
                case 6: {
                    System.out.print("Nhập số nguyên cần chuyển sang nhị phân: ");
                    int n = sc.nextInt();
                    System.out.print("Dạng nhị phân của " + n + " là: ");
                    deQuy.chuyenNP(n);
                    System.out.println();
                    break;
                }
                case 7: {
                    System.out.print("Nhập kích thước bàn cờ cho bài toán N-Queen: ");
                    int n = sc.nextInt();
                    deQuy.quayLui(n);
                    break;
                }
                case 8: {
                    int[] arr = nhapMang();
                    deQuy.bubbleSort(arr); 
                    break;
                }
                case 9: {
                    int[] arr = nhapMang();
                    deQuy.selectionSort(arr); 
                    break;
                }
                case 10: {
                    int[] arr = nhapMang();
                    deQuy.quickSort(arr, 0, arr.length - 1);
                    System.out.println("Mảng sau khi sắp xếp QuickSort:");
                    deQuy.printArray(arr);  // Correct method to print the array after sorting
                    break;
                }
                case 0:
                    System.out.println("Quay lại menu chính...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
        } while (c1 != 0);
    }

    public void menuKhuDQ() {
        int c2;
        do {
            System.out.println("\n╔═══════════════════════════════════════╗");
            System.out.println("║           MENU KHỬ ĐỆ QUY             ║");
            System.out.println("╠═══════════════════════════════════════╣");
            System.out.println("║ 1. Khử đệ quy Giai thừa               ║");
            System.out.println("║ 2. Khử đệ quy dãy Fibonacci           ║");
            System.out.println("║ 3. Tính giai thừa không dùng đệ quy   ║");
            System.out.println("║ 4. Tính lũy thừa không dùng đệ quy    ║");
            System.out.println("║ 0. Quay lại menu chính                ║");
            System.out.println("╚═══════════════════════════════════════╝");
            System.out.print("Mời bạn chọn: ");
            c2 = sc.nextInt();

            switch (c2) {
                case 1: {
                    System.out.print("Nhập số cần tính giai thừa: ");
                    int n = sc.nextInt();
                    System.out.println("Giai thừa của " + n + " là: " + khuDQ.gthua(n));
                    break;
                }
                case 2: {
                    System.out.print("Nhập số Fibonacci cần tính: ");
                    int n = sc.nextInt();
                    System.out.println("Số hạng thứ " + n + " của Fibonacci là: " + khuDQ.Fibo(n));
                    break;
                }
                case 3: {
                    System.out.print("Nhập số cần tính giai thừa: ");
                    int n = sc.nextInt();
                    System.out.println("Giai thừa của " + n + " là: " + khuDQ.gthua(n));
                    break;
                }
                case 4: {
                    System.out.print("Nhập cơ số: ");
                    int x = sc.nextInt();
                    System.out.print("Nhập số mũ: ");
                    int n = sc.nextInt();
                    System.out.println(x + "^" + n + " = " + khuDQ.power(x, n));
                    break;
                }
                case 0:
                    System.out.println("Quay lại menu chính...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
        } while (c2 != 0);
    }

    private int[] nhapMang() {
        System.out.print("Nhập số lượng phần tử: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public void combination(int[] arr, int n, int k, int start, int currLen, boolean[] used) {
        if (currLen == k) {
            for (int i = 0; i < n; i++) {
                if (used[i])
                    System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        if (start == n)
            return;

        used[start] = true;
        combination(arr, n, k, start + 1, currLen + 1, used);

        used[start] = false;
        combination(arr, n, k, start + 1, currLen, used);
    }

    public static void main(String[] args) {
        menuDeQuy menu = new menuDeQuy();
        menu.mainMenu();
    }
}
