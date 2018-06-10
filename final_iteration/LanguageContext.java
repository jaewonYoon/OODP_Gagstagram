import javax.swing.JButton;
import javax.swing.JLabel;

public class LanguageContext {
   private Language state;
   
   public LanguageContext() {
      state = new English();
   }
   
   public void currentLanguage(Language newLanguage) {
      this.state = newLanguage;
   }
   
   public void changeLanguage(JLabel title, JLabel id, JLabel pw, JButton enter, JButton register, JButton lanbtn) {
      this.state.changeLanguage(this, title, id, pw, enter, register, lanbtn);
   }
}
