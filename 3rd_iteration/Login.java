import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField studentID;
    private JTextField password;
    private JButton enter;
    private JButton register;
 
    public Login(){
        super("LOGIN");
        setLayout(new GridLayout(4,5));
        JLabel label = new JLabel("Gagstagram");
        label.setFont(new Font("SanSerif",Font.PLAIN,41));
        add(label);
        add(new JLabel(""));
        add(new JLabel("StudentID"));
        
        studentID = new JTextField(10);
        
        add(studentID);
        add(new JLabel("Password"));
        password = new JPasswordField(10);
        add(password);
        enter = new JButton("ENTER");
        add(enter);
        ButtonHandler handler = new ButtonHandler();
        enter.addActionListener(handler);
        register = new JButton("Register");
        add(register);
        RegHandler regHandler = new RegHandler();
        register.addActionListener(regHandler);
    }
// ******************************* OK
    private class ButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
                String stu_ID = studentID.getText();
                String stu_password = password.getText();
           boolean found = false;
           for(int i = 0; i< Register.getNumberOfRegistry();i++) {
               if (stu_ID.equals(Register.getStudent()[i].getStudentID())) {
                   if(stu_password.equals(Register.getStudent()[i].getPassword())) {
                       JOptionPane.showMessageDialog(null, "Login Successful!!");
                       found = true;
                       setVisible(false);
                       View menu = new View();
                       menu.makeBasicView(stu_ID);
                   }
               }
           }
           if(found == false){
               JOptionPane.showMessageDialog(null, "Login Failed!!");
        
           }


        }
    }

    private class RegHandler implements  ActionListener{
        public void actionPerformed(ActionEvent event){
        	Object e=event.getSource();
        	if(e==register) {
        		Register register = new Register();
        	}
        }
    }


}
