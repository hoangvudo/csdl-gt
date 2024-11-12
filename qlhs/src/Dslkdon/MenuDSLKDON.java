package Dslkdon;

import java.util.Scanner;

public class MenuDSLKDON {
    EmployeeList employeeList = new EmployeeList();

    public void menuList() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║    ---- MENU QUẢN LÝ NHÂN SỰ ---     ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║ 1. Thêm nhân viên                    ║");
            System.out.println("║ 2. Xóa nhân viên                     ║");
            System.out.println("║ 3. Tìm kiếm nhân viên                ║");
            System.out.println("║ 4. Sắp xếp theo lương                ║");
            System.out.println("║ 5. Hiển thị danh sách nhân viên      ║");
            System.out.println("║ 6. Đọc danh sách nhân viên từ file   ║");
            System.out.println("║ 7. Ghi danh sách nhân viên ra file   ║");
            System.out.println("║ 8. Quay lại menu chính               ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Mời bạn chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    employeeList.addEmployees();
                    break;
                case 2:
                    System.out.print("Nhập ID nhân viên cần xóa: ");
                    int idToDelete = scanner.nextInt();
                    employeeList.delete(idToDelete);
                    System.out.println("Đã xóa thành công !");
                    break;
                case 3:
                    System.out.print("Nhập ID nhân viên cần tìm: ");
                    int idToSearch = scanner.nextInt();
                    Employee emp = employeeList.search(idToSearch);
                    if (emp != null) {
                        System.out.println(emp);  // Hiển thị thông tin nhân viên
                    } else {
                        System.out.println("Không tìm thấy nhân viên");
                    }
                    break;
                case 4:
                    employeeList.sortBySalary();  // Sắp xếp danh sách nhân viên theo lương
                    System.out.println("Danh sách đã sắp xếp :");
                    employeeList.displaySortedBySalary();
                    break;
                case 5:
                    employeeList.display();  // Hiển thị danh sách nhân viên
                    break;
                case 6:
                    System.out.print("Nhập tên file cần đọc: ");
                    String readFileName = scanner.next();
                    employeeList.readFromFile(readFileName);  // Đọc danh sách nhân viên từ file
                    break;
                case 7:
                    System.out.print("Nhập tên file cần ghi: ");
                    String writeFileName = scanner.next();
                    employeeList.writeToFile(writeFileName);  // Ghi danh sách nhân viên ra file
                    break;
                case 8:
                    System.out.println("Quay lại menu chính...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, mời bạn chọn lại.");
                    break;
            }
        } while (choice != 8);
    }
}
