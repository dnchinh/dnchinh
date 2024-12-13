package ASM;

import java.util.Comparator;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentManagement {
    // Danh sách lưu trữ sinh viên
    private static final List<Student> studentList = new ArrayList<>();

    // Thêm sinh viên
    public static void addStudent() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter Student ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Student Marks: ");
            double marks = Double.parseDouble(scanner.nextLine()); // Bắt lỗi nhập sai kiểu
            studentList.add(new Student(id, name, marks));
            System.out.println("Student added successfully!\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for marks. Please try again!\n");
        }
    }

    // Sửa thông tin sinh viên
    public static void editStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID to edit: ");
        String id = scanner.nextLine();
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                System.out.print("Enter new name: ");
                student.setName(scanner.nextLine());
                try {
                    System.out.print("Enter new marks: ");
                    student.setMarks(Double.parseDouble(scanner.nextLine())); // Bắt lỗi nhập sai kiểu
                    System.out.println("Student updated successfully!\n");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for marks. Update failed!\n");
                }
                return;
            }
        }
        System.out.println("Student not found!\n");
    }

    // Xóa sinh viên
    public static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                iterator.remove();
                System.out.println("Student removed successfully!\n");
                return;
            }
        }
        System.out.println("Student not found!\n");
    }

    // Sắp xếp sinh viên theo điểm bằng Bubble Sort
    public static void sortStudentsByMarks() {
        int n = studentList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (studentList.get(j).getMarks() < studentList.get(j + 1).getMarks()) {
                    // Hoán đổi hai phần tử
                    Student temp = studentList.get(j);
                    studentList.set(j, studentList.get(j + 1));
                    studentList.set(j + 1, temp);
                }
            }
        }
         if (studentList.isEmpty()) {
            System.out.println("No students to display!\n");
        } else {
            System.out.println("Student List (sorted by marks descending):");
            for (Student student : studentList) {
                System.out.println(student);
            }
            System.out.println();
        }

    }

    // Hiển thị danh sách sinh viên
    public static void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display!\n");
        } else {
            // Sắp xếp danh sách trước khi hiển thị
            System.out.println("The list of student is : ");
            for (Student student : studentList) {
                System.out.println(student);
            }
            System.out.println();
        }
    }

    // Hàm main - menu chính
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Sort Students by Marks");
                System.out.println("5. Display Students");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int choice = Integer.parseInt(scanner.nextLine()); // Bắt lỗi nhập sai kiểu

                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> editStudent();
                    case 3 -> deleteStudent();
                    case 4 -> {
                        sortStudentsByMarks();
                        System.out.println("Students sorted by marks in descending order using Bubble Sort!\n");
                    }
                    case 5 -> displayStudents();
                    case 6 -> {
                        System.out.println("Exiting program. Goodbye!");
                        scanner.close(); // Đóng scanner trước khi thoát
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again!\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number!\n");
            }
        }
    }
}

class Student {
    private String id;
    private String name;
    private double marks;

    // Constructor
    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}
