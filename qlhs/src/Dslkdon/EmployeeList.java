package Dslkdon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {  
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Lương: " + salary;
    }
}

class Node {
    Employee data;
    Node next;

    public Node(Employee data) {
        this.data = data;
        this.next = null;
    }
}

public class EmployeeList {
    private Node head;
    private Scanner scanner = new Scanner(System.in); // Khai báo Scanner

    public void add(Employee data) {
        if (search(data.id) != null) {  // Kiểm tra nếu đã có nhân viên với ID này
            System.out.println("Mã nhân viên " + data.id + " đã tồn tại. Vui lòng nhập mã khác.");
            return;
        }

        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    public void addEmployees() {
        System.out.print("Nhập số lượng nhân viên cần thêm: ");
        int numberOfEmployees = scanner.nextInt();
        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.println("Nhập thông tin nhân viên thứ " + (i + 1) + ": ");
            System.out.print("Nhập ID: ");
            int id = scanner.nextInt();
            System.out.print("Nhập tên: ");
            scanner.nextLine(); // Dọn sạch bộ đệm
            String name = scanner.nextLine();
            System.out.print("Nhập lương: ");
            double salary = scanner.nextDouble();
            add(new Employee(id, name, salary));
            System.out.println("Đã thêm nhân viên thành công");
        }
    }
    
    public void delete(int id) {
        if (head == null) return;
        if (head.data.id == id) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data.id != id) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public Employee search(int id) {
        Node current = head;
        while (current != null) {
            if (current.data.id == id) return current.data;
            current = current.next;
        }
        return null;
    }

    public Employee searchByName(String name) {
        Node current = head;
        while (current != null) {
            if (current.data.name.equalsIgnoreCase(name)) return current.data;
            current = current.next;
        }
        return null;
    }

    public void display() {
        // Dòng tiêu đề với viền trên của bảng
        System.out.println("╔═══════╦══════════════════════╦════════════╗");
        System.out.printf("║ %-5s ║ %-20s ║ %-10s ║\n", "ID", "Tên", "Lương");
        System.out.println("╠═══════╬══════════════════════╬════════════╣");

        // Dòng dữ liệu của bảng
        Node current = head;
        while (current != null) {
            Employee emp = current.data;
            System.out.printf("║ %-5d ║ %-20s ║ %-10.2f ║\n", emp.id, emp.name, emp.salary);
            current = current.next;
            
            // Kiểm tra nếu còn nhân viên tiếp theo để hiển thị dòng phân cách
            if (current != null) {
                System.out.println("╠═══════╬══════════════════════╬════════════╣");
            }
        }

        // Dòng viền dưới của bảng
        System.out.println("╚═══════╩══════════════════════╩════════════╝");
    }



    public void displaySortedBySalary() {
        if (head == null) return;

        Node current = head;
        Node sortedList = null;

        while (current != null) {
            Node next = current.next;
            sortedList = insertInSortedOrder(sortedList, current);
            current = next;
        }
        
        Node displayCurrent = sortedList;
        while (displayCurrent != null) {
            System.out.println(displayCurrent.data);
            displayCurrent = displayCurrent.next;
        }
    }

    private Node insertInSortedOrder(Node sortedList, Node newNode) {
        if (sortedList == null || newNode.data.salary > sortedList.data.salary) {
            newNode.next = sortedList;
            return newNode;
        } else {
            Node current = sortedList;
            while (current.next != null && current.next.data.salary >= newNode.data.salary) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            return sortedList;
        }
    }

    public int count() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public double calculateAverageSalary() {
        if (head == null) return 0;
        
        double total = 0;
        int count = 0;
        Node current = head;
        while (current != null) {
            total += current.data.salary;
            count++;
            current = current.next;
        }
        return total / count;
    }

    public void sortBySalary() {
        if (head == null || head.next == null) return;
        Node current = head;
        Node index;
        Employee temp;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.data.salary < index.data.salary) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    public void readFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                double salary = Double.parseDouble(data[2].trim());
                Employee employee = new Employee(id, name, salary);
                add(employee);
            }
            System.out.println("Đọc danh sách nhân viên từ file thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    public void writeToFile(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            Node current = head;
            while (current != null) {
                Employee employee = current.data;
                bw.write(employee.id + "," + employee.name + "," + employee.salary + "\n");
                current = current.next;
            }
            System.out.println("Ghi danh sách nhân viên ra file thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
}
