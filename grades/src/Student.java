import java.util.Date;

public class Student {
    public double gpa;
    public String name;
    public Date birthday;
    public String major;

    public Student(String name, double gpa, Date birthday, String major) {
        this.name = name;
        this.gpa = Math.round(gpa * 100.0) / 100.0;
        this.birthday = birthday;
        this.major = major;
    }
    public String getName() {
        return name;
    }
    public double getGpa() {
        return gpa;
    }
    public Date getBirthday() {
        return birthday;
    }
    public String getMajor() {
        return major;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public String toString() {
        return this.name + " --- " + this.gpa + " " + this.birthday + " " + this.major;
    }
}