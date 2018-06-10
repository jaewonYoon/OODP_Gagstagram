import javax.swing.JButton;
import javax.swing.JLabel;

public class English implements Language {
      @Override
   public void changeLanguage(LanguageContext languageContext, JLabel title, JLabel id, JLabel pw, JButton enter,
         JButton register, JButton lanbtn) {
      title.setText("Gagstagram");
      id.setText("StudentID");
      pw.setText("Password");
      enter.setText("ENTER");
      register.setText("Register");
      lanbtn.setText("한국어");
      
      languageContext.currentLanguage(new Korean());
   }

}
