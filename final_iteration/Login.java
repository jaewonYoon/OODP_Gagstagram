import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
	RemoteControl remote=new RemoteControl();
    public Login(){
       
        super("LOGIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);		
		Dimension dS=Toolkit.getDefaultToolkit().getScreenSize(); // 윈도우 size
		Dimension dF=getSize(); 							// 창 size
		setLocation((int)((dS.getWidth()-dF.getWidth())/2),(int)((dS.getHeight()-dF.getHeight())/2)); //<======================가운데 위치 찾고	,default 창 위치 지정. 						
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
        setContentPane(new JLabel(new ImageIcon("./pic1.png")));
        getContentPane().setLayout(new GridLayout(5,6));
        
        title = new JLabel("Gagstagram");
        title.setFont(new Font("SanSerif",Font.PLAIN,41));
        getContentPane().add(title);
        
        lanbtn = new JButton("�븳援��뼱");
        getContentPane().add(lanbtn);
        LanguageHandler languagehandler = new LanguageHandler();
        lanbtn.addActionListener(languagehandler);

        
        //StudentID �엯�젰��
        id = new JLabel("StudentID");
        getContentPane().add(id);
        studentID = new JTextField(10);
        getContentPane().add(studentID);
        

        //password �엯�젰��
        pw = new JLabel("password");
        getContentPane().add(pw);
        password = new JPasswordField(10);
        getContentPane().add(password);

        //Enter 踰꾪듉
        enter = new JButton("ENTER");
        getContentPane().add(enter);
        //Enter �궎 �닃���쓣�떆 �룞�옉
        ButtonHandler handler = new ButtonHandler();
        enter.addActionListener(handler);

        //Register 踰꾪듉
        register = new JButton("Register");
        getContentPane().add(register);
        RegHandler regHandler = new RegHandler();
        register.addActionListener(regHandler);
        setVisible(true);

    }

    //Enter �궎 �닃���쓣�떆 �룞�옉-HANDLER
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
                       SettingOnCommand menu1=new SettingOnCommand(menu);
                       remote.setCommand(1, menu1);
                       remote.OnButtonPressed(1);
                   }
               }
           }
           if(found == false){
               JOptionPane.showMessageDialog(null, "Login Failed!!");
        
           }


        }
    }

    //Regist �궎瑜� �닃���쓣�떆 �룞�옉-HANDLER
    private class RegHandler implements  ActionListener{
        public void actionPerformed(ActionEvent event){

            //Register �겢�옒�뒪濡� �꽆源�
            Register register = new Register();


        }
    }

    private class LanguageHandler implements ActionListener{
       public void actionPerformed(ActionEvent event) {
          language.changeLanguage(title, id, pw, enter, register, lanbtn);
       }
    }
}
