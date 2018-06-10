import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public interface Language {
   public void changeLanguage(LanguageContext languageContext, JLabel title, JLabel id, JLabel pw, JButton enter,
         JButton register, JButton lanbtn);
}
