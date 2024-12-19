import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ModePanel extends JPanel {

  JButton next = new JButton("SONRAKI");
  JLabel hyphen = new JLabel("-");
  JTextField s1 = new JTextField();
  JTextField s2 = new JTextField();

  JButton Mode1 = new JButton("30s");
  JButton Mode2 = new JButton("50s");
  JButton Mode3 = new JButton("Aralıq");

  Sual[] ALL = Exam.prepareQuestionArray();
  JLabel chosen = new JLabel(ALL.length + " sual, Seçilən : ");

  Character mode = '1';
  int start = 1;
  int end = ALL.length;
  int count = 30;

    Color c = new Color(30, 200, 200);
    Font f = new Font("Times New Roman", Font.PLAIN, 20);
  public ModePanel() throws Exception {
    this.setLayout(null);
    this.setBackground(new Color(50, 50, 50));

    next.setBounds(935, 595, 200, 50);
    next.setBackground(new Color(30, 200, 100));
    next.setFont(f);
    next.setFocusable(false);
    next.setVisible(false);

    chosen.setBounds(486, 530, 300, 200);
    chosen.setFont(f);
    chosen.setFocusable(false);
    chosen.setOpaque(false);
    chosen.setForeground(Color.white);

    s1.setBounds(879, 527, 130, 50);
    s2.setBounds(1049, 527, 130, 50);
    s1.setFont(f);
    s2.setFont(f);
    s1.setVisible(false);
    s2.setVisible(false);
    hyphen.setBounds(1009, 517, 40, 50);
    hyphen.setHorizontalAlignment(JLabel.CENTER);
    hyphen.setFont(new Font("Times New Roman", Font.PLAIN, 80));
    hyphen.setVisible(false);
    hyphen.setForeground(Color.white);

    Mode1.setBackground(c);
    Mode1.setFont(f);
    Mode1.setFocusable(false);
    Mode1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mode = '1';
        chosen.setText(ALL.length + " sual, Seçilən : " + "30 SUAL");
        next.setVisible(true);
        s1.setVisible(false);
        s2.setVisible(false);
        hyphen.setVisible(false);
        hyphen.setText("-");
        hyphen.setForeground(Color.white);
        s1.setText("");
        s2.setText("");
        count = 30;
      }
    });
    Mode2.setBackground(c);
    Mode2.setFont(f);
    Mode2.setFocusable(false);
    Mode2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mode = '2';
        chosen.setText(ALL.length + " sual, Seçilən : " + "50 SUAL");
        next.setVisible(true);
        s1.setVisible(false);
        s2.setVisible(false);
        hyphen.setText("-");
        hyphen.setForeground(Color.white);
        s1.setText("");
        s2.setText("");
        hyphen.setVisible(false);
        count = 50;
      }
    });
    Mode3.setFont(f);
    Mode3.setBackground(c);
    Mode3.setFocusable(false);
    Mode3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mode = '3';
        chosen.setText(ALL.length + " sual, Seçilən : " + "ARALIQ");
        s1.setVisible(true);
        s2.setVisible(true);
        hyphen.setVisible(true);
        next.setVisible(true);
        hyphen.setText("-");
        hyphen.setForeground(Color.white);
        s1.setText("");
        s2.setText("");
      }
    });

    Mode1.setBounds(93, 210, 300, 300);
    Mode2.setBounds(486, 210, 300, 300);
    Mode3.setBounds(879, 210, 300, 300);

    this.add(chosen);
    this.add(s1);
    this.add(s2);
    this.add(hyphen);
    this.add(Mode1);
    this.add(Mode2);
    this.add(Mode3);
    this.add(next);
  }

}
