
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.plaf.metal.MetalCheckBoxIcon;

public class test {
  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setSize(200, 200);
    JCheckBox cb = new JCheckBox();
    cb.setIcon(new MetalCheckBoxIcon(){
       protected int getControlSize(){
        return 30;
      } 
    });
    f.add(cb);
    cb.setOpaque(false);
    cb.setPreferredSize(new Dimension(1,1));
    cb.setHideActionText(true);
    cb.setHorizontalAlignment(JCheckBox.CENTER);
    cb.setBorder(BorderFactory.createLineBorder(Color.green,50,true));
    f.getContentPane().setBackground(Color.red);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
