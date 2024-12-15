import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class QuizPanel extends JPanel implements ActionListener {

  JButton finish = new JButton("BİTİR");
  JButton back = new JButton("BAĞlA");
  JButton allQuestions = new JButton("BÜTÜN SUALLAR");
  JButton previous = new JButton("Əvvəlki");
  JButton next = new JButton("Növbəti");
  JButton show = new JButton("Doğru cavabı göstər");
  AllQuestions allQ;

  JPanel quesionPanel = new JPanel();
  Color c = new Color(30, 200, 200);
  Font f = new Font("Times New Roman", Font.PLAIN, 20);
  Sual[] questions;
  int position = 0;

  public QuizPanel(Sual[] suals) {
    this.questions = suals;
    this.setLayout(null);
    this.setBackground(new Color(50, 50, 50));
    back.setBounds(40, 30, 200, 50);
    back.setBackground(Color.red);
    back.setFont(f);
    back.setFocusable(false);

    previous.setBounds(40, 640, 300, 30);
    previous.setBackground(new Color(190, 120, 80));
    previous.addActionListener(this);
    previous.setFocusable(false);
    previous.setFont(f);

    allQuestions.setBounds(280, 30, 200, 50);
    allQuestions.setBackground(Color.green);
    allQuestions.setFont(f);
    allQuestions.setFocusable(false);
    allQuestions.addActionListener(this);

    finish.setBounds(280, 30, 200, 50);
    finish.setBackground(Color.cyan);
    finish.setFont(f);
    finish.setFocusable(false);
    finish.addActionListener(this);

    next.setBounds(380, 640, 300, 30);
    next.setBackground(new Color(190, 120, 80));
    next.addActionListener(this);
    next.setFocusable(false);
    next.setFont(f);

    show.setBounds(720, 640, 300, 30);
    show.setBackground(new Color(30, 200, 100));
    show.addActionListener(this);
    show.setFocusable(false);
    show.setFont(f);

    for (int t = 0; t < questions.length; t++) {
      int i = t;
      questions[i].number = i + 1;
      questions[i].correctQuestion();
      for (int j = 0; j < 5; j++) {
        if (questions[i].answers[j].getText().contains("√")) {
          questions[i].correctAnswer = j;
        }
        questions[i].correctAnswers(questions[i].answers[j], j);
        JRadioButton jb = questions[i].ticks[j];
        int s = i;
        int d = j;
        questions[i].answers[j].addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            if (jb.isSelected()) {
              questions[s].bg.clearSelection();
              questions[s].isAnswered = false;
              questions[s].currentAnswer = -1;
              allQ.check[s] = false;
            } else {
              jb.setSelected(true);
              questions[s].isAnswered = true;
              questions[s].currentAnswer = d;
              allQ.check[s] = true;
            }
          }
        });

      }
    }
    JLabel[] jlb = new JLabel[questions.length];
    for (int i = 0; i < questions.length; i++) {
      jlb[i] = new JLabel(questions[i].question.getText());
    }
    allQ = new AllQuestions(jlb);
    for (int j = 0; j < questions.length; j++) {
      int i = j;
      allQ.all[j].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          position = i;
          QuizPanel.this.removeAll();
          QuizPanel.this.add(questions[i]);
          QuizPanel.this.add(back);
          QuizPanel.this.add(previous);
          QuizPanel.this.add(next);
          QuizPanel.this.add(show);
          QuizPanel.this.add(allQuestions);
          QuizPanel.this.revalidate();
          QuizPanel.this.repaint();
        }
      });

    }

    this.add(show);
    this.add(questions[0]);
    this.add(back);
    this.add(previous);
    this.add(next);
    this.add(allQuestions);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == next) {
      this.remove(questions[position]);
      if (position == questions.length - 1) {
        position = -1;
      }
      this.add(questions[++position]);
      this.revalidate();
      this.repaint();
    } else if (e.getSource() == previous) {
      this.remove(questions[position]);
      if (position == 0) {
        position = questions.length;
      }
      this.add(questions[--position]);
      this.revalidate();
      this.repaint();
    } else if (e.getSource() == show) {
      Sual q = questions[position];
      q.answers[q.correctAnswer].setBackground(Color.orange);
      q.answers[q.correctAnswer].setForeground(new Color(50, 50, 50));
    } else if (e.getSource() == allQuestions) {
      allQ.setTicks();
      this.removeAll();
      this.add(allQ);
      this.add(finish);
      this.add(back);
      this.revalidate();
      this.repaint();
    } else if (e.getSource() == finish) {
      int corrrect = 0;
      if (JOptionPane.showOptionDialog(null, "Bitirmək istədiyinə əminsən?", "Finish Quiz", JOptionPane.YES_NO_OPTION,
          JOptionPane.INFORMATION_MESSAGE, null, null, 0) == 0) {
        for (int i = 0; i < questions.length; i++) {
          if (questions[i].currentAnswer == questions[i].correctAnswer) {
            corrrect++;
            allQ.all[i].setBackground(Color.green);
            questions[i].answers[questions[i].correctAnswer].setBackground(Color.green);
            questions[i].answers[questions[i].correctAnswer].setForeground(Color.black);
          } else if (questions[i].currentAnswer == -1) {
            allQ.all[i].setBackground(Color.DARK_GRAY);
            questions[i].answers[questions[i].correctAnswer].setBackground(Color.lightGray);
            questions[i].answers[questions[i].correctAnswer].setForeground(Color.black);
          }else{
            allQ.all[i].setBackground(Color.red);
            questions[i].answers[questions[i].correctAnswer].setBackground(Color.green);
            questions[i].answers[questions[i].correctAnswer].setForeground(Color.black);
            questions[i].answers[questions[i].currentAnswer].setBackground(Color.red);
            questions[i].answers[questions[i].currentAnswer].setForeground(Color.black);
          }
          
        }
        JOptionPane.showMessageDialog(null,"Doğru cavabların sayı : " + corrrect);

      }
    }
  }

}
