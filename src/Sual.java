import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Sual extends JPanel {
  JPanel qs = new JPanel();
  JPanel tcks = new JPanel();
  JLabel question = new JLabel();
  int number;
  JButton[] answers = new JButton[5];
  JRadioButton[] ticks = new JRadioButton[5];
  ButtonGroup bg = new ButtonGroup();
  int correctAnswer;
  int currentAnswer = -1;
  boolean isAnswered = false;
  Font f = new Font("Times New Roman", Font.PLAIN, 20);
  Color c = new Color(50, 50, 50);

  public Sual(String head, String[] ans) {
    this.setBounds(40, 110, 1200, 530);
    this.setLayout(null);
    this.setBackground(c);

    qs.setLayout(new GridLayout(6, 1, 0, 10));
    qs.setBackground(c);
    qs.setBounds(20, 0, 1150, 530);
    tcks.setLayout(new GridLayout(5, 1, 0, 10));
    tcks.setBounds(0, 88, 20, 442);
    tcks.setBackground(c);

    this.question.setText(head);
    question.setOpaque(false);
    question.setForeground(Color.white);
    question.setFont(f);
    question.setBorder(null);
    qs.add(question);
    for (int i = 0; i < 5; i++) {
      answers[i] = new JButton();
      answers[i].setText(ans[i]);
      answers[i].setBackground(c);
      answers[i].setHorizontalAlignment(JLabel.LEFT);
      answers[i].setForeground(Color.white);
      answers[i].setFont(f);
      answers[i].setFocusable(false);
      answers[i].setBorder(null);
      qs.add(answers[i]);

      ticks[i] = new JRadioButton();
      ticks[i].setFont(f);
      ticks[i].setBackground(c);
      ticks[i].setSize(10, 10);
      bg.add(ticks[i]);
      tcks.add(ticks[i]);
      this.add(qs);
      this.add(tcks);
    }

    mixAnswers();


  }

  public void mixAnswers() {
    Random r = new Random();
    ArrayList<Integer> randomHolder = new ArrayList<>();
    int e = 0;
    int nextRandomNumber = r.nextInt(5);

    while (e < 5) {
      if (randomHolder.contains(nextRandomNumber)) {
        nextRandomNumber = r.nextInt(5);
      } else {
        randomHolder.add(nextRandomNumber);
        nextRandomNumber = r.nextInt(5);
        ++e;
      }
    }

    for (int i = 0; i < 5; ++i) { // {4,1,3,0,2}
      String temp = this.answers[i].getText();
      this.answers[i].setText(this.answers[randomHolder.get(i)].getText());
      this.answers[randomHolder.get(i)].setText(temp);
      randomHolder.set(randomHolder.indexOf(i), randomHolder.get(i));
    }

  }

  public void correctQuestion() {
    for (char c = this.question.getText().charAt(0); Character.isDigit(c); c = this.question.getText().charAt(0)) {
      this.question.setText(this.question.getText().substring(1));
    }
    if (this.question.getText().charAt(0) == '.') {
      this.question.setText(this.question.getText().substring(1));
    }
    this.question.setText("<html>" + this.number + ". " + this.question.getText().strip() + "</html>");
  }

  public void correctAnswers(JButton j, int i) {
    j.setText("<html>" + j.getText().substring(1).strip() + "</html>");
  }

}
