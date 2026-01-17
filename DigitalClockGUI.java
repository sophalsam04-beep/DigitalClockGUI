
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

class DigitalClockGUI extends JFrame implements Runnable {

    JLabel timeLabel;

    DigitalClockGUI() {
        // Frame settings
        setTitle("Digital Clock");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label settings
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setForeground(Color.blue);
        timeLabel.setBackground(Color.white);
        timeLabel.setOpaque(true);

        add(timeLabel);
        setVisible(true);

        // Start thread
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            Calendar cal = Calendar.getInstance();

            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minute = cal.get(Calendar.MINUTE);
            int second = cal.get(Calendar.SECOND);

            String time = String.format("%02d:%02d:%02d", hour, minute, second);
            timeLabel.setText(time);

            try {
                Thread.sleep(1000); // update every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DigitalClockGUI();
    }
}
