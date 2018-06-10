import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Korean implements Language {
   @Override
   public void changeLanguage(LanguageContext languageContext, JLabel title, JLabel id, JLabel pw, JButton enter,
         JButton register, JButton lanbtn) {
      title.setText("객스타그램");
      id.setText("학번");
      pw.setText("암호");
      enter.setText("확인");
      register.setText("가입");
      lanbtn.setText("日本語");
      
      languageContext.currentLanguage(new Japanese());
   }

}
