import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.metal.MetalCheckBoxIcon;

public class AllQuestions extends JScrollPane {
  JPanel main = new JPanel();
  JButton[] all;
  JCheckBox[] ticks;
  boolean[] check ;

  public AllQuestions(JLabel[] questions) {
    this.setBounds(20, 110, 1200, 530);
    this.getVerticalScrollBar().setUnitIncrement(20);
    this.setBorder(null);
    check  = new boolean[questions.length];
    ticks = new JCheckBox[questions.length];
    main.setLayout(new GridBagLayout());
    main.setBackground(new Color(50, 50, 50));
    main.setBorder(null);
    all = new JButton[questions.length];
    GridBagConstraints gbc = new GridBagConstraints();
    for (int j = 0; j < questions.length; j++) {
      int i = j;
      gbc.gridx = 0;
      gbc.gridy = i;
      gbc.anchor = GridBagConstraints.WEST;
      gbc.ipady = 50;
      gbc.insets = new Insets(0, 0, 0, 0);
      all[i] = new JButton(questions[i].getText());
      all[i].setPreferredSize(new Dimension(1100, 30));
      all[i].setFont(new Font("Times New Roman", Font.PLAIN, 20));
      all[i].setBackground(new Color(50, 50, 50));
      all[i].setForeground(Color.white);
      all[i].setFocusable(false);
      all[i].setBorder(null);
      all[i].setHorizontalAlignment(JButton.LEFT);
      main.add(all[i], gbc);
      gbc.gridx = 1;
      gbc.ipady = 0;
      ticks[i] = new JCheckBox();
      ticks[i].setIcon(new MetalCheckBoxIcon() {
        protected int getControlSize() {
          return 50;
        }
      });
      ticks[i].setHorizontalAlignment(JCheckBox.CENTER);
      ticks[i].setPreferredSize(new Dimension(50, 50));
      ticks[i].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

          if (ticks[i].isSelected()) {
            ticks[i].setSelected(false);
          } else {
            ticks[i].setSelected(true);
          }
        }
      });
      main.add(ticks[i], gbc);
    }

    this.setViewportView(main);
  }

  public void setTicks() {
    for (int i = 0; i < check.length; i++) {
      boolean c = check[i];
      if (!c) {
        ticks[i].setSelected(false);
      } else {
        ticks[i].setSelected(true);
      }
    }

  }
}
