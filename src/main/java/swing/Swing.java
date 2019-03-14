package swing;

import fx.FXBuilder;
import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Swing extends JFrame {

    private static final int WAIT_TIME = 5000; // millis
    private Timer timer;
    private JFXPanel jfxPanel;
    private JDialog dialog;
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    public Swing(String title) {
        super(title);
        JPanel jPanel = new JPanel();
        jPanel.setPreferredSize(SCREEN_SIZE);
        this.getContentPane().add(jPanel);
        this.setLocationRelativeTo(null);
        this.setBounds(0, 0, SCREEN_SIZE.width,SCREEN_SIZE.height);
        this.requestFocus();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jfxPanel = new JFXPanel();
        jfxPanel.setSize(SCREEN_SIZE);
        FXBuilder fXbuilder = new FXBuilder(jfxPanel);
        jfxPanel = fXbuilder.build();
        initDialog();
        initTimer();
        eventHandler();
    }


    private void eventHandler() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                restartTimer();
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                restartTimer();
            }
        });
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

    private void initDialog(){
        dialog = new JDialog(this);
        dialog.setLocation(0,0);
        dialog.setPreferredSize(SCREEN_SIZE);
        dialog.setContentPane(jfxPanel);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.pack();
    }

    public void initTimer() {
        this.timer = new Timer(WAIT_TIME, (event) -> {
            dialog.setVisible(true);
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void restartTimer() {
        System.out.println("restart");
        timer.restart();
    }

}
