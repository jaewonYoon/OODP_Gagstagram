import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField studentID;
    private JTextField password;
    private JLabel id;
    private JLabel pw;
    private JLabel title;
    private JButton enter;
    private JButton register;
    private JButton lanbtn;
    private LanguageContext language = new LanguageContext();
    
    public Login(){
       
       
        super("LOGIN");
        getContentPane().setLayout(new GridLayout(4,5));


        title = new JLabel("Gagstagram");
        title.setFont(new Font("SanSerif",Font.PLAIN,41));
        getContentPane().add(title);
        
        lanbtn = new JButton("한국어");
        getContentPane().add(lanbtn);
        LanguageHandler languagehandler = new LanguageHandler();
        lanbtn.addActionListener(languagehandler);

        
        //StudentID 입력란
        id = new JLabel("StudentID");
        getContentPane().add(id);
        studentID = new JTextField(10);
        getContentPane().add(studentID);
        

        //password 입력란
        pw = new JLabel("password");
        getContentPane().add(pw);
        password = new JPasswordField(10);
        getContentPane().add(password);

        //Enter 버튼
        enter = new JButton("ENTER");
        getContentPane().add(enter);
        //Enter 키 눌렀을시 동작
        ButtonHandler handler = new ButtonHandler();
        enter.addActionListener(handler);

        //Register 버튼
        register = new JButton("Register");
        getContentPane().add(register);
        RegHandler regHandler = new RegHandler();
        register.addActionListener(regHandler);


    }

    //Enter 키 눌렀을시 동작-HANDLER
    private class ButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
                String stu_ID = studentID.getText();
                String stu_password = password.getText();
           boolean found = false;
           for(int i = 0; i< Register.getNumberOfRegistry();i++) {
               if (stu_ID.equals(Register.getStudent()[i].getStudentID())) {
                   if(stu_password.equals(Register.getStudent()[i].getPassword())) {
                       JOptionPane.showMessageDialog(null, "Login Successful!!");
                       //Menu 로 넘어감
                       Menu menu = new Menu(stu_ID);
                       found = true;
                   }
               }
           }
           if(found == false){
               JOptionPane.showMessageDialog(null, "Login Failed!!");
        
           }


        }
    }

    //Regist 키를 눌렀을시 동작-HANDLER
    private class RegHandler implements  ActionListener{
        public void actionPerformed(ActionEvent event){

            //Register 클래스로 넘김
            Register register = new Register();


        }
    }

    private class LanguageHandler implements ActionListener{
       public void actionPerformed(ActionEvent event) {
          language.changeLanguage(title, pw, id, enter, register, lanbtn);
       }
    }
}
