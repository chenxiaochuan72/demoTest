package test.内部类;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        System.out.println("start");
    }

    public class TimePrinter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone,the time is"
            + Instant.ofEpochMilli(e.getWhen()));
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }

    public static void main(String[] args) {
        TalkingClock talkingClock = new TalkingClock(1009, true);
        talkingClock.start();
        JOptionPane.showMessageDialog(null,"quit program?");
        System.exit(0);
    }
}
