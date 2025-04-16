import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App {
    public static void main(String[] args) throws Exception {
        StudentBook studentBook = StudentGenerator.generateStudentBook(50);

        //Main Menu
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        JPanel mainMenu = new JPanel();
        mainMenu.setBackground(new Color(125, 135, 150));
        mainMenu.setLayout(new BoxLayout(mainMenu, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Welcome to the Student Management System!");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        title.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));

        JButton addStudentBtn = new JButton("Add a new student");
        JButton viewStudentsBtn = new JButton("View all students");
        JButton deleteStudentBtn = new JButton("Delete a student");
        JButton exitBtn = new JButton("Exit");

        JButton[] buttons = { addStudentBtn, viewStudentsBtn, deleteStudentBtn, exitBtn };
        for (JButton btn : buttons) {
            btn.setFont(new Font("SansSerif", Font.PLAIN, 16));
            btn.setBackground(new Color(30, 144, 255));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(250, 40));
            btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        mainMenu.add(title);
        mainMenu.add(Box.createRigidArea(new Dimension(0, 100)));
        mainMenu.add(addStudentBtn);
        mainMenu.add(Box.createRigidArea(new Dimension(0, 10)));
        mainMenu.add(viewStudentsBtn);
        mainMenu.add(Box.createRigidArea(new Dimension(0, 10)));
        mainMenu.add(deleteStudentBtn);
        mainMenu.add(Box.createRigidArea(new Dimension(0, 10)));
        mainMenu.add(exitBtn);



        // Add Student
        JPanel addStudentPanel = new JPanel();
        addStudentPanel.setBackground(new Color(125, 135, 150));
        addStudentPanel.setLayout(new BoxLayout(addStudentPanel, BoxLayout.Y_AXIS));

        JLabel addStudentTitle = new JLabel("Add a new student");
        addStudentTitle.setForeground(Color.WHITE);
        addStudentTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
        addStudentTitle.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        addStudentTitle.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        JLabel gpaLabel = new JLabel("GPA:");
        JLabel majorLabel = new JLabel("Major:");
        JLabel birthdayLabel = new JLabel("Birthday (dd/mm/yyyy):");

        JLabel[] labels = { nameLabel, gpaLabel, majorLabel, birthdayLabel };
        for (JLabel label : labels) {
            label.setFont(new Font("SansSerif", Font.PLAIN, 16));
            label.setForeground(Color.WHITE);
            label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            label.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            label.setMaximumSize(new Dimension(290, 40));
        }

        JTextField nameField = new JTextField();
        JTextField gpaField = new JTextField();
        JTextField majorField = new JTextField();
        JTextField birthdayField = new JTextField();

        JTextField[] fields = { nameField, gpaField, majorField, birthdayField };
        for (JTextField field : fields) {
            field.setFont(new Font("SansSerif", Font.PLAIN, 16));
            field.setForeground(Color.GRAY);
            field.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            field.setMaximumSize(new Dimension(250, 40));
            field.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        }

        JButton addStudentSubmitBtn = new JButton("Add Student");
        JButton cancelBtn = new JButton("Cancel");

        JButton[] addStudentButtons = { addStudentSubmitBtn, cancelBtn };
        for (JButton btn : addStudentButtons) {
            btn.setFont(new Font("SansSerif", Font.PLAIN, 16));
            btn.setBackground(new Color(30, 144, 255));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(250, 40));
            btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        addStudentPanel.add(addStudentTitle);
        addStudentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addStudentPanel.add(nameLabel);
        addStudentPanel.add(nameField);
        addStudentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addStudentPanel.add(gpaLabel);
        addStudentPanel.add(gpaField);
        addStudentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addStudentPanel.add(majorLabel);
        addStudentPanel.add(majorField);
        addStudentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addStudentPanel.add(birthdayLabel);
        addStudentPanel.add(birthdayField);
        addStudentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addStudentPanel.add(addStudentSubmitBtn);
        addStudentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addStudentPanel.add(cancelBtn);
        addStudentPanel.add(Box.createRigidArea(new Dimension(0, 20)));




        cardPanel.add(mainMenu, "mainMenu");
        cardPanel.add(addStudentPanel, "addStudent");


        // Main Menu
        // Button Actions 
        addStudentBtn.addActionListener(e -> cardLayout.show(cardPanel, "addStudent"));
        // viewStudentsBtn.addActionListener(e -> cardLayout.show(cardPanel, "viewStudents"));
        // deleteStudentBtn.addActionListener(e -> cardLayout.show(cardPanel, "deleteStudent"));
        exitBtn.addActionListener(e -> System.exit(0));

        frame.add(cardPanel);
        frame.setVisible(true);

    }
}