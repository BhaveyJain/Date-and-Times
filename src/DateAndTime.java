import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DateAndTime implements Runnable {

    ActionListener e = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public void run() {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new DateAndTime());
    }

}
