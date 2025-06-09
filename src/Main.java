import javax.swing.UIManager;

public class Main {
  public static void main(String[] args) throws Exception {
    try {
      UIManager.setLookAndFeel(
          UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Exception e) {
    }
    new Prog();
  }
}
