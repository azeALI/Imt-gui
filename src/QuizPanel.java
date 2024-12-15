import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuizPanel extends JPanel implements ActionListener {

  JButton back = new JButton("QUIT");
  JButton allQuestions = new JButton("Bütün suallar");
  JButton previous = new JButton("previous");
  JButton next = new JButton("next");
  JButton show = new JButton("corrrect ans.");
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

    allQuestions.setBounds(280,30,200,50);
    allQuestions.setBackground(Color.green);
    allQuestions.setFont(f);
    allQuestions.setFocusable(false);
    allQuestions.addActionListener(this);

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

    for (int i = 0; i < questions.length; i++) {
      questions[i].number = i + 1;
      questions[i].correctQuestion();
      for (int j = 0; j < 5; j++) {
        if (questions[i].answers[j].getText().contains("√")) {
          questions[i].correctAnswer = j;
        }
        questions[i].correctAnswers(questions[i].answers[j], j);
      }
    }

    this.add(show);
    this.add(questions[0]);
    this.add(back);
    this.add(previous);
    this.add(next);
    this.add(allQuestions);

  }

  public void generateAllQ() {
    JLabel[] jlb = new JLabel[questions.length];
    boolean[] check = new boolean[questions.length];
    for (int i = 0; i < questions.length; i++) {
      jlb[i] = new JLabel(questions[i].question.getText());
      check[i] = questions[i].isAnswered;
    }
    allQ = new AllQuestions(jlb, check);
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
    }
    else if (e.getSource()==allQuestions){
      generateAllQ();
      this.removeAll();
      this.add(allQ);
      this.add(back);
      this.revalidate();
      this.repaint();
    }
  }

}
