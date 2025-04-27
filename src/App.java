import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class App {
    public static void main(String[] args) throws Exception {
        TreeMap<String, Font> fonts = FontLibrary.uploadFonts(); // Fonts

        JFrame frame = new JFrame("Tuonela");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.width * 9 / 16);
        frame.setLocation(0, 0);
        frame.setResizable(false);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        // Entry Screen
        JPanel enterScreen = new JPanel();
        enterScreen.setBackground(Color.BLACK);
        enterScreen.setLayout(new GridLayout(8,5));

        JLabel titleLabel = new JLabel();
        titleLabel.setFont(fonts.get("titleFont"));
        Screen.write("Tuonela", titleLabel, 100, Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);

        JButton startButton = new JButton("Start");
        JButton exitButton = new JButton("Exit");

        JButton[] buttons = {startButton, exitButton};
        for (JButton button : buttons) {
            button.setFont(fonts.get("buttonFont"));
            button.setBackground(Color.BLACK);
            button.setForeground(Color.DARK_GRAY);
            button.setBorderPainted(false);
            button.setPreferredSize(new Dimension(10, 10));
            button.setFocusable(false);
            button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }

        Screen.appearDelay(startButton, 1500);    
        Screen.appearDelay(exitButton, 2200);    
        

        Screen.fillEmpty(enterScreen, 17); // Fill empty spaces
        enterScreen.add(titleLabel);
        Screen.fillEmpty(enterScreen, 14);
        enterScreen.add(startButton);
        Screen.fillEmpty(enterScreen, 4);
        enterScreen.add(exitButton);

        exitButton.addActionListener(e -> {
            System.exit(0);
        });








        // Character Creator Screen
        JPanel characterCreator = new JPanel();
        characterCreator.setBackground(Color.BLACK);

        JPanel characterPath = new JPanel();
        characterPath.setBackground(Color.BLACK);

        // Button from the previous screen to enter this screen
        startButton.addActionListener(e -> {
            cardLayout.show(mainPanel, "CharacterCreator");

            JLabel characterLabel = new JLabel("");
            Screen.write("Enter your character's name:", characterLabel, 30, Color.WHITE);
            characterCreator.setLayout(new GridLayout(6,1));
            characterLabel.setFont(fonts.get("subtitleFont"));
            characterLabel.setHorizontalAlignment(JLabel.CENTER);
            characterLabel.setVerticalAlignment(JLabel.CENTER);

            JPanel namePanel = new JPanel();
            namePanel.setBackground(Color.BLACK);

            JTextArea nameInput = new JTextArea(1, 10);
            nameInput.setFont(fonts.get("baseFont"));
            nameInput.setBackground(Color.BLACK);
            nameInput.setForeground(Color.WHITE);
            nameInput.setPreferredSize(new Dimension(350, 27));
            nameInput.setCaretColor(Color.WHITE);
            nameInput.setMargin(new java.awt.Insets(10, 10, 10, 10));
            nameInput.setFocusable(true);
            nameInput.requestFocusInWindow();
            nameInput.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY, 1));
            nameInput.setAlignmentX(0.5f);
            nameInput.setAlignmentY(0.5f);

            JLabel errorLabel = new JLabel("Invalid name.");
            errorLabel.setFont(fonts.get("errorFont"));
            errorLabel.setForeground(Color.RED);
            errorLabel.setVisible(false);
            errorLabel.setHorizontalAlignment(JLabel.CENTER);
            errorLabel.setVerticalAlignment(JLabel.NORTH);

            JPanel submitButtonPanel = new JPanel();
            submitButtonPanel.setBackground(Color.BLACK);

            JButton submitButton = new JButton("Submit");
            Screen.appearDelay(submitButton, 1500);
            submitButton.setFont(fonts.get("buttonFont"));
            submitButton.setBackground(Color.BLACK);
            submitButton.setForeground(Color.DARK_GRAY);
            submitButton.setBorderPainted(false);
            submitButton.setFocusable(false);
            submitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            submitButtonPanel.add(submitButton);
            

            namePanel.add(nameInput);

            Screen.fillEmpty(characterCreator, 2);
            characterCreator.add(characterLabel);
            characterCreator.add(namePanel);
            characterCreator.add(errorLabel);
            characterCreator.add(submitButtonPanel);








            // Character Path Screen
            submitButton.addActionListener(e2 -> {
                String name = nameInput.getText().trim();
                if (name.length() > 29 || name.isEmpty() || name.isBlank()) {
                    errorLabel.setVisible(true);
                } else {
                    errorLabel.setVisible(false);
                    cardLayout.show(mainPanel, "CharacterPath");

                    characterPath.setLayout(new GridLayout(6,1));

                    JLabel pathLabel = new JLabel("");
                    Screen.write("Choose your path:", pathLabel, 30, Color.WHITE);
                    pathLabel.setFont(fonts.get("subtitleFont"));
                    pathLabel.setHorizontalAlignment(JLabel.CENTER);
                    pathLabel.setVerticalAlignment(JLabel.CENTER);

                    JPanel pathButtonPanel1 = new JPanel();
                    JPanel pathButtonPanel2 = new JPanel();
                    JPanel pathButtonPanel3 = new JPanel();

                    JPanel[] pathButtonPanels = {pathButtonPanel1, pathButtonPanel2, pathButtonPanel3};
                    for (JPanel panel : pathButtonPanels) {
                        panel.setBackground(Color.BLACK);
                    }
                
                    JButton pathButton1 = new JButton("Strength");
                    JButton pathButton2 = new JButton("Intelligence");
                    JButton pathButton3 = new JButton("Agility");

                    JButton[] pathButtons = {pathButton1, pathButton2, pathButton3};
                    int pathDelay = 1000;
                    for (JButton button : pathButtons) {
                        Screen.appearDelay(button, pathDelay);
                        button.setFont(fonts.get("baseFont"));
                        button.setBackground(Color.BLACK);
                        button.setForeground(Color.DARK_GRAY);
                        button.setFocusable(false);
                        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                        button.setPreferredSize(new Dimension(300, 100));
                        button.setBorder(javax.swing.BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
                        pathDelay += 750;
                    }

                    pathButtonPanel1.add(pathButton1);
                    pathButtonPanel2.add(pathButton2);
                    pathButtonPanel3.add(pathButton3);

                    characterPath.add(pathLabel);
                    Screen.fillEmpty(characterPath, 1);
                    characterPath.add(pathButtonPanel1);
                    characterPath.add(pathButtonPanel2);
                    characterPath.add(pathButtonPanel3);

                    for (JButton button : pathButtons) {
                        button.addActionListener(e3 -> {
                            String path = button.getText();
                            System.out.println("Character Name: " + name);
                            System.out.println("Character Path: " + path);
                            // Here you can create the player object and set its attributes based on the chosen path
                            // Player player = new Player(name, path);
                            // System.out.println(player.name + " has chosen the " + player.path + " path.");
                        });
                    }
                }
            });
        });

        mainPanel.add(enterScreen, "EnterScreen");
        mainPanel.add(characterCreator, "CharacterCreator");
        mainPanel.add(characterPath, "CharacterPath");
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}