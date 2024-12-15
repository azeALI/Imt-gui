import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Prog extends JFrame {
  ModePanel modePanel = new ModePanel();
  QuizPanel quizPanel;

  public Prog() throws Exception {
    this.setSize(1280, 720);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setLocationRelativeTo(null);

    modePanel.next.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (modePanel.mode == '3') {
          for (Character c : modePanel.s1.getText().toCharArray()) {
            if (Character.isLetter(c)) {
              modePanel.hyphen.setText("!");
              modePanel.hyphen.setForeground(Color.red);
              return;
            }
          }
          for (Character c : modePanel.s2.getText().toCharArray()) {
            if (Character.isLetter(c)) {
              modePanel.hyphen.setText("!");
              modePanel.hyphen.setForeground(Color.red);
              return;
            }
          }
          int start = Integer.parseInt(modePanel.s1.getText().strip());
          int end = Integer.parseInt(modePanel.s2.getText().strip());
          if (start >= end) {
            modePanel.hyphen.setText("!");
            modePanel.hyphen.setForeground(Color.red);
            return;
          } else if (start > modePanel.ALL.length || start <= 0 || end > modePanel.ALL.length || end <= 0) {
            modePanel.hyphen.setText("!");
            modePanel.hyphen.setForeground(Color.red);
            return;
          } else {
            modePanel.start = start;
            modePanel.end = end;
            modePanel.count = end - start + 1;
          }
        }

        Prog.this.newQuizPanel();
        Prog.this.remove(modePanel);
        Prog.this.add(quizPanel);
        Prog.this.revalidate();
        Prog.this.repaint();

        modePanel.hyphen.setText("-");
        modePanel.hyphen.setForeground(Color.white);
        modePanel.s1.setText("");
        modePanel.s2.setText("");
        modePanel.s1.setVisible(false);
        modePanel.s2.setVisible(false);
        modePanel.hyphen.setVisible(false);
      }
    });
    this.add(modePanel);
    this.setVisible(true);
  }

  public void newQuizPanel() {
    quizPanel = new QuizPanel(
        Exam.randomiseArray(modePanel.ALL, modePanel.start - 1, modePanel.end - 1, modePanel.count));
    quizPanel.back.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Prog.this.remove(quizPanel);
        Prog.this.add(modePanel);
        modePanel.start = 1;
        modePanel.end = modePanel.ALL.length;
        modePanel.chosen.setText("Seçilən : ");
        modePanel.next.setVisible(false);
        Prog.this.revalidate();
        Prog.this.repaint();
      }
    });

  }
}
