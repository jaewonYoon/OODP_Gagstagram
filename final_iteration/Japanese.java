import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Japanese implements Language {
   @Override
   public void changeLanguage(LanguageContext languageContext, JLabel title, JLabel id, JLabel pw, JButton enter,
         JButton register, JButton lanbtn) {
      title.setText("インスタグラム");
      id.setText("学番");
      pw.setText("パスワード");
      enter.setText("確認");
      register.setText("加入");
      lanbtn.setText("English");
      
      languageContext.currentLanguage(new English());
      
   }

}

