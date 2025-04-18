import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class App {
    public static void main(String[] args) throws Exception {
        File file = new File("src/GeneratorSetup.txt");
        Scanner scanner = new Scanner(file);
        final StudentBook studentBook;
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number < 0) {
            number = 0;
            } else if (number > 300) {
                number = 300;
            }
            studentBook = StudentGenerator.generateStudentBook(number);
        } else {
            System.out.println("No valid integer found in the file.");
            studentBook = new StudentBook();
        }
        scanner.close();

        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 630);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        ImageIcon icon = new ImageIcon("src/icon.png");
        frame.setIconImage(icon.getImage());

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        //Main Menu
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

        JLabel addStudentErrorField = new JLabel("Please fill in all fields.");
        addStudentErrorField.setFont(new Font("SansSerif", Font.ITALIC, 16));
        addStudentErrorField.setForeground(Color.LIGHT_GRAY);
        addStudentErrorField.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        addStudentErrorField.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        addStudentErrorField.setVisible(false);

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
        addStudentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addStudentPanel.add(addStudentErrorField);



        // Show All Students
        JPanel viewStudentsPanel = new JPanel();
        viewStudentsPanel.setBackground(new Color(125, 135, 150));
        viewStudentsPanel.setLayout(new BoxLayout(viewStudentsPanel, BoxLayout.Y_AXIS));

        JTextArea viewStudentsArea = new JTextArea(20, 50);
        viewStudentsArea.setEditable(false);
        viewStudentsArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
        viewStudentsArea.setForeground(Color.GRAY);
        viewStudentsArea.setText(studentBook.viewStudentsString());

        JScrollPane scrollPane = new JScrollPane(viewStudentsArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(700, 400));

        JPanel viewStudentsList = new JPanel();
        viewStudentsList.add(Box.createRigidArea(new Dimension(20, 20)));
        viewStudentsList.add(scrollPane);
        viewStudentsList.add(Box.createRigidArea(new Dimension(20, 20)));
        viewStudentsList.setBackground(new Color(125, 135, 150));

        JButton viewStudentsBackBtn = new JButton("Back to Main Menu");
        viewStudentsBackBtn.setFont(new Font("SansSerif", Font.PLAIN, 16));
        viewStudentsBackBtn.setBackground(new Color(30, 144, 255));
        viewStudentsBackBtn.setForeground(Color.WHITE);
        viewStudentsBackBtn.setFocusPainted(false);
        viewStudentsBackBtn.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        viewStudentsBackBtn.setMaximumSize(new Dimension(250, 40));
        viewStudentsBackBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        viewStudentsBackBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        viewStudentsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        viewStudentsPanel.add(viewStudentsList);
        viewStudentsPanel.add(viewStudentsBackBtn);



        // Delete Student
        JPanel deleteStudentPanel = new JPanel();
        deleteStudentPanel.setBackground(new Color(125, 135, 150));
        deleteStudentPanel.setLayout(new BoxLayout(deleteStudentPanel, BoxLayout.Y_AXIS));

        JLabel deleteStudentTitle = new JLabel("Delete a student");
        deleteStudentTitle.setForeground(Color.WHITE);
        deleteStudentTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
        deleteStudentTitle.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        deleteStudentTitle.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));

        JLabel deleteStudentLabel = new JLabel("Enter the name of the student to delete:");
        deleteStudentLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        deleteStudentLabel.setForeground(Color.WHITE);
        deleteStudentLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        deleteStudentLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel deleteStudentErrorField = new JLabel("Student not found.");
        deleteStudentErrorField.setFont(new Font("SansSerif", Font.ITALIC, 16));
        deleteStudentErrorField.setForeground(Color.LIGHT_GRAY);
        deleteStudentErrorField.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        deleteStudentErrorField.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        deleteStudentErrorField.setVisible(false);

        JTextField deleteStudentField = new JTextField();
        deleteStudentField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        deleteStudentField.setForeground(Color.GRAY);
        deleteStudentField.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        deleteStudentField.setMaximumSize(new Dimension(250, 40));
        deleteStudentField.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JButton deleteStudentSubmitBtn = new JButton("Delete Student");
        JButton deleteStudentCancelBtn = new JButton("Cancel");

        JButton[] deleteStudentButtons = { deleteStudentSubmitBtn, deleteStudentCancelBtn };
        for (JButton btn : deleteStudentButtons) {
            btn.setFont(new Font("SansSerif", Font.PLAIN, 16));
            btn.setBackground(new Color(30, 144, 255));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(250, 40));
            btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        deleteStudentPanel.add(deleteStudentTitle);
        deleteStudentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        deleteStudentPanel.add(deleteStudentLabel);
        deleteStudentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        deleteStudentPanel.add(deleteStudentField);
        deleteStudentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        deleteStudentPanel.add(deleteStudentSubmitBtn);
        deleteStudentPanel.add(deleteStudentCancelBtn);
        deleteStudentPanel.add(deleteStudentErrorField);




        cardPanel.add(mainMenu, "mainMenu");
        cardPanel.add(addStudentPanel, "addStudent");
        cardPanel.add(viewStudentsPanel, "viewStudents");
        cardPanel.add(deleteStudentPanel, "deleteStudent");

        // Button Actions 
        // Main Menu
        addStudentBtn.addActionListener(e -> cardLayout.show(cardPanel, "addStudent"));
        viewStudentsBtn.addActionListener(e -> cardLayout.show(cardPanel, "viewStudents"));
        deleteStudentBtn.addActionListener(e -> cardLayout.show(cardPanel, "deleteStudent"));
        exitBtn.addActionListener(e -> System.exit(0));
        // Add Student
        addStudentSubmitBtn.addActionListener(e -> {
            if (nameField.getText().isEmpty() || gpaField.getText().isEmpty() || majorField.getText().isEmpty() || birthdayField.getText().isEmpty()) {
                addStudentErrorField.setVisible(true);
            } else {
                String birthdayStr = birthdayField.getText();
                String[] dateParts = birthdayStr.split("/");
                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int year = Integer.parseInt(dateParts[2]);
                java.time.LocalDate localDate = java.time.LocalDate.of(year, month, day);
                java.util.Date birthday = java.sql.Date.valueOf(localDate);
                studentBook.addStudent(nameField.getText(), Double.parseDouble(gpaField.getText()), birthday, majorField.getText());
                viewStudentsArea.setText(studentBook.viewStudentsString());
                cardLayout.show(cardPanel, "mainMenu");
                addStudentErrorField.setVisible(false);
            }
            nameField.setText("");
            gpaField.setText("");
            majorField.setText("");
            birthdayField.setText("");
        });
        cancelBtn.addActionListener(e -> {
            cardLayout.show(cardPanel, "mainMenu");
            nameField.setText("");
            gpaField.setText("");
            majorField.setText("");
            birthdayField.setText("");
            addStudentErrorField.setVisible(false);
        });
        // View Students
        viewStudentsBackBtn.addActionListener(e -> cardLayout.show(cardPanel, "mainMenu"));
        // Delete Student
        deleteStudentSubmitBtn.addActionListener(e -> {
            String studentName = deleteStudentField.getText();
            if (studentBook.students.containsKey(studentName)) {
                studentBook.removeStudent(studentName);
                viewStudentsArea.setText(studentBook.viewStudentsString());
                deleteStudentField.setText("");
                cardLayout.show(cardPanel, "mainMenu");
                deleteStudentErrorField.setVisible(false);
            } else {
                deleteStudentErrorField.setVisible(true);
                deleteStudentField.setText("");
            }
        });
        deleteStudentCancelBtn.addActionListener(e -> {
            cardLayout.show(cardPanel, "mainMenu");
            deleteStudentField.setText("");
            deleteStudentErrorField.setVisible(false);
        });


        frame.add(cardPanel);
        frame.setVisible(true);
    }
}