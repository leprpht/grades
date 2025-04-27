
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Screen {
    public static void write(String text, JLabel label, int delay, Color color) {
        label.setForeground(color);
        final int[] index = {0};
        Timer timer = new Timer(delay, e -> {
            if (index[0] < text.length()) {
                label.setText(label.getText() + text.charAt(index[0]));
                index[0]++;
            } else {
                ((Timer) e.getSource()).stop();
            }
        });
        timer.start();
    }
    public static void write(String text, JLabel label, int delay) {
        final int[] index = {0};
        Timer timer = new Timer(delay, e -> {
            if (index[0] < text.length()) {
                label.setText(label.getText() + text.charAt(index[0]));
                index[0]++;
            } else {
                ((Timer) e.getSource()).stop();
            }
        });
        timer.start();
    }
    public static void appearDelay(JComponent component, int delay) {
        component.setVisible(false);
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                SwingUtilities.invokeLater(() -> {
                    component.setVisible(true);
                });

            } catch (InterruptedException e) {
                // e.printStackTrace();
            }
        }).start();
    }
    public static void fillEmpty(JComponent component, int count) {
        for (int i = 0; i < count; i++) {
            component.add(Box.createRigidArea(new Dimension(0, 0)));
        }
    }
    public static void fillEmpty(JComponent component, int count, int width, int height) {
        for (int i = 0; i < count; i++) {
            component.add(Box.createRigidArea(new Dimension(width, height)));
        }
    }
    public static void fillEmpty(JComponent component, int count, Dimension dimension) {
        for (int i = 0; i < count; i++) {
            component.add(Box.createRigidArea(dimension));
        }
    }
    public static void fillEmpty(JComponent component, int count, int width) {
        for (int i = 0; i < count; i++) {
            component.add(Box.createRigidArea(new Dimension(width, 0)));
        }
    }
}