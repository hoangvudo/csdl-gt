package Main;

import java.util.Scanner;

import Dequy.menuDeQuy;
import Dslkdon.MenuDSLKDON;

public class menu {

    public static void main(String[] args) {
        int mainChoice;
        Scanner scanner = new Scanner(System.in);
        menuDeQuy deQuyMenu = new menuDeQuy();
        MenuDSLKDON dsldmenu = new MenuDSLKDON();

        do {
            // In ra menu chính
            System.out.println("╔═══════════════════════════════════════╗");
            System.out.println("║          ---- MENU CHÍNH ----         ║");
            System.out.println("╠═══════════════════════════════════════╣");
            System.out.println("║ 1. Làm việc với Đệ quy và khử Đệ quy  ║");
            System.out.println("║ 2. Làm việc với danh sách liên kết đơn║");
            System.out.println("║ 3. Thoát chương trình                 ║");
            System.out.println("╚═══════════════════════════════════════╝");
            System.out.print("Mời bạn chọn: ");
            
            mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    int subChoice;
                    do {
                        // In ra menu con cho Đệ quy
                        System.out.println("╔═════════════════════════════════════╗");
                        System.out.println("║         ---- MENU ĐỆ QUY ----       ║");
                        System.out.println("╠═════════════════════════════════════╣");
                        System.out.println("║ 1. Làm việc với Đệ quy              ║");
                        System.out.println("║ 2. Làm việc với khử Đệ quy          ║");
                        System.out.println("║ 3. Quay lại menu chính              ║");
                        System.out.println("╚═════════════════════════════════════╝");
                        System.out.print("Mời bạn chọn: ");
                        
                        subChoice = scanner.nextInt();

                        switch (subChoice) {
                            case 1:
                                deQuyMenu.menuDQ();
                                break;
                            case 2:
                                deQuyMenu.menuKhuDQ();
                                break;
                            case 3:
                                System.out.println("Quay lại menu chính...");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ, mời bạn chọn lại.");
                                break;
                        }
                    } while (subChoice != 3);
                    break;

                case 2:
                    dsldmenu.menuList();
                    break;

                case 3:
                    System.out.println("Thoát chương trình...");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, mời bạn chọn lại.");
                    break;
            }
        } while (mainChoice != 3);

        scanner.close();
    }
}
