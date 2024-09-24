import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import javax.swing.*;

public class ClockGUI extends JFrame implements ActionListener 
{
    private ClockDisplay clockDisplay;   
    private JLabel timeLabel;            
    private Timer timer;

    public ClockGUI() {
        clockDisplay = new ClockDisplay();
        
        timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Sans-Serif", Font.BOLD, 48));
        
        add(timeLabel);

        LocalTime currentTime = LocalTime.now();
        int currentHour = currentTime.getHour();
        int currentMinute = currentTime.getMinute();
        int currentSecond = currentTime.getSecond();
        
        clockDisplay.setTime(currentHour, currentMinute, currentSecond);

        timer = new Timer(1000, this); 
        timer.start();

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        clockDisplay.timeTick();
        timeLabel.setText(clockDisplay.gettime());
    }

    public static void main(String[] args) {
        new ClockGUI();
    }
}
