package fx;

import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class DialogScreenSaver {
    private Timer timer;
    private  final int waitTime;// millis
    private JFXPanel jfxPanel;
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private JDialog dialog;

    public DialogScreenSaver(Frame parent,Rectangle bounds,int waitTime){
        this.waitTime = waitTime;
        dialog = new JDialog(parent);
        this.dialog.setBounds(bounds);
        jfxPanel = new JFXPanel();
        initFX();
        initDialog();
        initTimer();
        eventHandler();
    }


    private void initFX(){
        jfxPanel.setBounds(this.dialog.getBounds());
        FXBuilder fXbuilder = new FXBuilder(jfxPanel);
        jfxPanel = fXbuilder.build();
    }

    private void initDialog(){
        dialog.setContentPane(jfxPanel);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        dialog.pack();
    }
    private void eventHandler(){
        this.jfxPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dialog.setVisible(false);
                restartTimer();
            }
        });
        this.jfxPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                dialog.setVisible(false);
                restartTimer();
            }
        });
    }

    public void initTimer() {
        this.timer = new Timer(waitTime, (event) -> dialog.setVisible(true));
        timer.setRepeats(false);
        timer.start();
    }

    public void restartTimer() {
        System.out.println("restart");
        timer.restart();
    }
}
