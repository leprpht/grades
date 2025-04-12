import java.util.Map;
import java.util.Date;
import java.util.HashMap;

public class StudentBook {
    public Map<String, Student> students;
    public StudentBook() {
        this.students = new HashMap<>();
    }
    public void addStudent(String name, double gpa, Date birthday, String major) {
        Student student = new Student(name, gpa, birthday, major);
        this.students.put(name, student);
    }
    public void removeStudent(String name) {
        if (this.students.containsKey(name)) {
            this.students.remove(name);
        } else {
            System.out.println("Student not found.");
        }
    }
    public void viewStudents() {
        for (Map.Entry<String, Student> entry : this.students.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}
