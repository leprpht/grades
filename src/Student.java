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
    @Override
    public String toString() {
        java.text.SimpleDateFormat dayFormat = new java.text.SimpleDateFormat("dd");
        java.text.SimpleDateFormat monthFormat = new java.text.SimpleDateFormat("MM");
        java.text.SimpleDateFormat yearFormat = new java.text.SimpleDateFormat("yyyy");
        return this.name + " --- " + this.gpa + " " + dayFormat.format(this.birthday) + "/" + monthFormat.format(this.birthday) + "/" + yearFormat.format(this.birthday) + " "  + this.major;
    }
}