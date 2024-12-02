import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Imt extends JFrame {

  JPanel ModePanel = new JPanel();
  JButton next = new JButton("NEXT");
  JLabel chosen = new JLabel("Seçilən : ");
  JButton Mode1 = new JButton("30s");
  JButton Mode2 = new JButton("50s");
  JButton Mode3 = new JButton("Aralıq");
  Character mode = '1';

  public Imt() {
    this.setSize(1280, 720);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    Color c = new Color(30, 200, 200);
    Font f = new Font("JetBrains Mono Bold", Font.PLAIN, 20);

    ModePanel.setLayout(null);
    ModePanel.setBackground(new Color(50, 50, 50));
    next.setBounds(879, 530, 300, 100);
    next.setBackground(new Color(30, 200, 100));
    next.setFont(f);
    next.setFocusable(false);
    next.setVisible(false);
    next.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
      }
    });
    chosen.setBounds(486, 530, 300, 200);
    chosen.setFont(f);
    chosen.setFocusable(false);
    chosen.setOpaque(false);
    chosen.setForeground(Color.white);

    Mode1.setBackground(c);
    Mode1.setFont(f);
    Mode1.setFocusable(false);
    Mode1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mode = '1';
        chosen.setText("Seçilən : " + Character.toString(mode));
        next.setVisible(true);
      }
    });
    Mode2.setBackground(c);
    Mode2.setFont(f);
    Mode2.setFocusable(false);
    Mode2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mode = '2';
        chosen.setText("Seçilən : " + Character.toString(mode));
        next.setVisible(true);
      }
    });
    Mode3.setFont(f);
    Mode3.setBackground(c);
    Mode3.setFocusable(false);
    Mode3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mode = '3';
        chosen.setText("Seçilən : " + Character.toString(mode));
        next.setVisible(true);
      }
    });

    Mode1.setBounds(93, 210, 300, 300);
    Mode2.setBounds(486, 210, 300, 300);
    Mode3.setBounds(879, 210, 300, 300);
    ModePanel.add(chosen);
    ModePanel.add(Mode1);
    ModePanel.add(Mode2);
    ModePanel.add(Mode3);
    ModePanel.add(next);
    this.add(ModePanel);
    this.setVisible(true);

  }

}
