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
        // Code to read input
        System.out.println("Enter student GPA:");
        // Code to read input
        System.out.println("Enter student birthday (YYYY-MM-DD):");
        // Code to read input
        System.out.println("Enter student major:");
        // Code to read input
    }
    public static void viewStudentsUI(StudentBook studentBook) {
        System.out.println("List of all students:");
        studentBook.viewStudents();
        System.out.println("===================================");
    }
    public static void deleteStudentUI(StudentBook studentBook) {
        System.out.println("Enter the name of the student to delete:");
        // Code to read input
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
}
