import java.util.Date;

public class StudentGenerator {
    public static String generateName() {
        String[] firstNames = {"Ava", "Liam", "Emma", "Noah", "Olivia", "Elijah", "Sophia", "James", "Isabella", "William", "Mia", "Benjamin", "Charlotte", "Lucas", "Amelia", "Henry", "Harper", "Alexander", "Evelyn", "Michael", "Abigail", "Ethan", "Emily", "Daniel", "Ella", "Matthew", "Elizabeth", "Sebastian", "Camila", "Jackson", "Luna", "Aiden", "Sofia", "Logan", "Avery", "David", "Mila", "Joseph", "Aria", "Samuel", "Scarlett", "Carter", "Penelope", "Owen", "Layla", "Wyatt", "Chloe", "John", "Victoria", "Jack", "Madison", "Luke", "Eleanor", "Jayden", "Grace", "Dylan", "Nora", "Grayson", "Riley", "Levi", "Zoey", "Isaac", "Hannah", "Gabriel", "Hazel", "Julian", "Lily", "Mateo", "Ellie", "Anthony", "Violet", "Jaxon", "Lillian", "Lincoln", "Zoe", "Joshua", "Stella", "Christopher", "Aurora", "Andrew", "Natalie", "Theodore", "Emilia", "Caleb", "Everly", "Ryan", "Leah", "Asher", "Aubrey", "Nathan", "Willow", "Thomas", "Addison", "Leo", "Lucy", "Isaiah", "Audrey", "Charles", "Bella", "Josiah", "Sophie", "Hudson", "Sadie", "Christian", "Skylar", "Hunter", "Ivy", "Eli", "Kinsley", "Jonathan", "Claire", "Jeremiah", "Aaliyah", "Ezekiel", "Brielle", "Colton", "Elena", "Landon", "Vivian", "Adrian", "Gianna", "Robert", "Naomi", "Angel", "Everleigh", "Maverick", "Kaylee", "Nicholas", "Samantha"};
        int randomIndex1 = (int) (Math.random() * firstNames.length);
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin", "Lee", "Perez", "Thompson", "White", "Harris", "Sanchez", "Clark", "Ramirez", "Lewis", "Robinson", "Walker", "Young", "Allen", "King", "Wright", "Scott", "Torres", "Nguyen", "Hill", "Flores", "Green", "Adams", "Nelson", "Baker", "Hall", "Rivera", "Campbell", "Mitchell", "Carter", "Roberts", "Gomez", "Phillips", "Evans", "Turner", "Diaz", "Parker", "Cruz", "Edwards", "Collins", "Reyes", "Stewart", "Morris", "Morales", "Murphy", "Cook", "Rogers", "Gutierrez", "Ortiz", "Morgan", "Cooper", "Peterson", "Bailey", "Reed", "Kelly", "Howard", "Ramos", "Kim", "Cox", "Ward", "Richardson", "Watson", "Brooks", "Chavez", "Wood", "James", "Bennett", "Gray", "Mendoza", "Ruiz", "Hughes", "Price", "Alvarez", "Castillo", "Sanders", "Patel", "Myers", "Long", "Ross", "Foster", "Jimenez", "Powell", "Jenkins", "Perry", "Russell", "Sullivan", "Bell", "Coleman", "Butler", "Henderson", "Barnes", "Gonzales", "Fisher", "Vasquez", "Simmons", "Romero", "Jordan", "Patterson", "Alexander", "Hamilton", "Graham", "Reyes", "Mendez"};
        int randomIndex2 = (int) (Math.random() * lastNames.length);
        return firstNames[randomIndex1] + " " + lastNames[randomIndex2];
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
    public static String generateMajor() {
        String[] majors = {"Computer Science", "Mathematics", "Physics", "Chemistry", "Biology", "Engineering", "Economics", "Psychology", "History", "Political Science", "Sociology", "Philosophy", "Linguistics", "Anthropology", "Art History", "Music", "Theater", "Dance", "Film Studies", "Creative Writing"};
        int randomIndex = (int) (Math.random() * majors.length);
        return majors[randomIndex];
    }
    public static Student generateStudent() {
        return new Student(generateName(), generateGPA(), generateBirthday(), generateMajor());
    }
    public static StudentBook generateStudentBook(int number) {
        StudentBook studentBook = new StudentBook();
        for (int i = 0; i < number; i++) {
            Student student = generateStudent();
            String name = student.getName();
            double gpa = student.getGpa();
            Date birthday = student.getBirthday();
            String major = student.getMajor();
            studentBook.addStudent(name, gpa, birthday, major);
        }
        return studentBook;
    }
}
