import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class StudentGenerator {
    public static String generateName(String[] firstNames, String[] lastNames) {
        int randomFirstNameIndex = (int) (Math.random() * firstNames.length);
        int randomLastNameIndex = (int) (Math.random() * lastNames.length);
        return firstNames[randomFirstNameIndex].trim() + " " + lastNames[randomLastNameIndex].trim();
    }
    public static Date generateBirthday() {
        int year = (int) (Math.random() * 11) + 1995;
        int month = (int) (Math.random() * 12) + 1;
        int day = (int) (Math.random() * 28) + 1;
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar.getTime();
    }
    public static double generateGPA() {
        double gpa = Math.random() * 2 + 2;
        gpa = Math.round(gpa * 100.0) / 100.0;
        return gpa;
    }
    public static String generateMajor(String[] majors) {
        int randomMajorIndex = (int) (Math.random() * majors.length);
        return majors[randomMajorIndex].trim();
    }
    public static Student generateStudent() {
        return new Student(generateName(readFirstNames(), readLastNames()), generateGPA(), generateBirthday(), generateMajor(readMajors()));
    }
    public static StudentBook generateStudentBook(int number) {
        StudentBook studentBook = new StudentBook();
        int repeatCount = 0;
        for (int i = 0; i < number; i++) {
            if (repeatCount > 10) {
                System.out.println("Too many attempts to generate a unique student. Stopping generation.");
                break;
            }
            Student student = generateStudent();
            String name = student.getName();
            if (studentBook.students.containsKey(name)) {
                i--;
                repeatCount++;
                continue;
            }
            double gpa = student.getGpa();
            Date birthday = student.getBirthday();
            String major = student.getMajor();
            studentBook.addStudent(name, gpa, birthday, major);
        }
        return studentBook;
    }
    public static String[] readFirstNames() {
        String[] firstNames = new String[0];
        try {
            File file = new File("src/FirstNames.txt");
            Scanner scanner = new Scanner(file);
            StringBuilder names = new StringBuilder();
            while (scanner.hasNextLine()) {
                names.append(scanner.nextLine());
            }
            firstNames = names.toString().split(",");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return firstNames;
    }
    public static String[] readLastNames() {
        String[] lastNames = new String[0];
        try {
            File file = new File("src/LastNames.txt");
            Scanner scanner = new Scanner(file);
            StringBuilder names = new StringBuilder();
            while (scanner.hasNextLine()) {
                names.append(scanner.nextLine());
            }
            lastNames = names.toString().split(",");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return lastNames;
    }
    public static String[] readMajors() {
        String[] majors = new String[0];
        try {
            File file = new File("src/Majors.txt");
            Scanner scanner = new Scanner(file);
            StringBuilder names = new StringBuilder();
            while (scanner.hasNextLine()) {
                names.append(scanner.nextLine());
            }
            majors = names.toString().split(",");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return majors;
    }
}
