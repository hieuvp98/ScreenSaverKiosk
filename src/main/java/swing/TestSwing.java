package swing;

import fx.DialogScreenSaver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TestSwing extends JFrame {
    private DialogScreenSaver dialogScreenSaver;
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    public TestSwing(String title){
        super(title);
        JPanel jPanel = new JPanel();
        jPanel.setPreferredSize(SCREEN_SIZE);
        this.getContentPane().add(jPanel);
        this.setLocationRelativeTo(null);
        this.setBounds(0, 0, SCREEN_SIZE.width,SCREEN_SIZE.height);
        this.requestFocus();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dialogScreenSaver = new DialogScreenSaver(this,new Rectangle(0,0,SCREEN_SIZE.width,SCREEN_SIZE.height),5000);
        eventHandler();
    }

    private void eventHandler() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dialogScreenSaver.restartTimer();
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                dialogScreenSaver.restartTimer();
            }
        });

    }
}
