import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.metal.MetalCheckBoxIcon;

public class AllQuestions extends JScrollPane {
  JPanel main = new JPanel();
  JButton[] all;

  public AllQuestions(JLabel[] questions, boolean[] check) {
    this.setBounds(20, 110, 1200, 530);
    this.getVerticalScrollBar().setUnitIncrement(20);
    main.setLayout(new GridBagLayout());
    main.setBackground(new Color(50, 50, 50));
    all = new JButton[questions.length];
    GridBagConstraints gbc = new GridBagConstraints();
    for (int i = 0; i < questions.length; i++) {
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
      all[i].setBorder(BorderFactory.createLineBorder(Color.white, 1, true));
      all[i].setHorizontalAlignment(JButton.LEFT);
      main.add(all[i], gbc);
      gbc.gridx = 1;
      gbc.ipady = 0;
      JCheckBox cb = new JCheckBox();
      cb.setIcon(new MetalCheckBoxIcon() {
        protected int getControlSize() {
          return 50;
        }
      });
      cb.setHorizontalAlignment(JCheckBox.CENTER);
      cb.setPreferredSize(new Dimension(50, 50));
      boolean c = check[i];
      if (!c) {
        cb.setSelected(false);
      } else {
        cb.setSelected(true);
      }
      cb.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

          if (cb.isSelected()) {
            cb.setSelected(false);
          } else {
            cb.setSelected(true);
          }
        }
      });
      main.add(cb, gbc);
    }

    this.setViewportView(main);
  }
}
