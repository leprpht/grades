public class App {
    public static void main(String[] args) throws Exception {
        StudentBook studentBook = StudentGenerator.generateStudentBook(50);
        UI.cycleUI(studentBook);
    }
}
