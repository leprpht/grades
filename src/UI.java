import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class UI {
    public static void mainUI(StudentBook studentBook) {
        System.out.println("===================================");
        System.out.println("Welcome to the Student Management System!");
        System.out.println("Please select an option:");
        System.out.println("1. Add a new student");
        System.out.println("2. View all students");
        System.out.println("3. Delete a student");
        System.out.println("4. Exit");
    }
    public static void addStudentUI(StudentBook studentBook) {
        System.out.println("Enter student name:");
        String name = readInput();
        System.out.println("Enter student GPA:");
        String gpaStr = readInput();
        double gpa = Double.parseDouble(gpaStr);
        System.out.println("Enter student birthday (YYYY-MM-DD):");
        String birthdayStr = readInput();
        LocalDate birthday = LocalDate.parse(birthdayStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Date birthdayDate = java.sql.Date.valueOf(birthday);
        System.out.println("Enter student major:");
        String major = readInput();
        studentBook.addStudent(name, gpa, birthdayDate, major);
        studentAddedUI();
    }
    public static void viewStudentsUI(StudentBook studentBook) {
        System.out.println("List of all students:");
        studentBook.viewStudents();
        System.out.println("===================================");
    }
    public static void deleteStudentUI(StudentBook studentBook) {
        System.out.println("Enter the name of the student to delete:");
        String name = readInput();
        if (studentBook.students.containsKey(name)) {
            studentBook.removeStudent(name);
            studentDeletedUI();
        } else {
            studentNotFoundUI();
        }
    }
    public static void exitUI() {
        System.out.println("Exiting the program. Goodbye!");
        System.exit(0);
    }
    public static void invalidOptionUI() {
        System.out.println("Invalid option. Please try again.");
    }
    public static void studentNotFoundUI() {
        System.out.println("Student not found. Please try again.");
    }
    public static void studentAddedUI() {
        System.out.println("Student added successfully.");
    }
    public static void studentDeletedUI() {
        System.out.println("Student deleted successfully.");
    }
    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();        
    }
    public static void readOption(StudentBook studentBook) {
        String option = readInput();
        switch (option) {
            case "1" -> addStudentUI(studentBook);
            case "2" -> viewStudentsUI(studentBook);
            case "3" -> deleteStudentUI(studentBook);
            case "4" -> exitUI();
            default -> invalidOptionUI();
        }
    }
    public static void cycleUI(StudentBook studentBook) {
        while (true) {
            mainUI(studentBook);
            readOption(studentBook);
        }
    }
}
