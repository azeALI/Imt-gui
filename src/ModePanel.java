import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.LayerUI;

public class ModePanel extends JPanel {

  JButton next = new JButton("NEXT");
  JButton back = new JButton("BACK");
  JLabel chosen = new JLabel("Seçilən : ");
  JButton Mode1 = new JButton("30s");
  JButton Mode2 = new JButton("50s");
  JButton Mode3 = new JButton("Aralıq");
  Character mode = '1';

  public Imt() {
    Color c = new Color(30, 200, 200);
    Font f = new Font("JetBrains Mono Bold", Font.PLAIN, 20);

    this.setLayout(null);
    this.setBackground(new Color(50, 50, 50));

    next.setBounds(935, 595, 200, 50);
    next.setBackground(new Color(30, 200, 100));
    next.setFont(f);
    next.setFocusable(false);
    next.setVisible(false);
    next.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
      }
    });

    back.setBounds(140, 75, 200, 50);

    back.setBackground(Color.red);
    back.setFont(f);
    back.setFocusable(false);
    back.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e){
        this.setVisible(false);
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
        chosen.setText("Seçilən : " + "30 SUAL");
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
        chosen.setText("Seçilən : " + "50 SUAL");
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
        chosen.setText("Seçilən : " + "ARALIQ");
        next.setVisible(true);
      }
    });

    Mode1.setBounds(93, 210, 300, 300);
    Mode2.setBounds(486, 210, 300, 300);
    Mode3.setBounds(879, 210, 300, 300);


    this.add(chosen);
    this.add(Mode1);
    this.add(Mode2);
    this.add(Mode3);
    this.add(next);
  }

}
