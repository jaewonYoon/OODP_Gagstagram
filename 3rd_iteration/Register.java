import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Register extends JFrame{

    private JTextField studentID;
    private JTextField password;
    private JTextField name;
    private JButton enter;
    private static Student[] Student = new Student[10]; 
    private static int numberOfRegistry = 0;
    private static int currentStudent = 0;


    public Register() {
    	super("Register");
        JFrame frame = new JFrame("Register");
        setVisible(true);
        this.setSize(600,300);					//<=============================다 같이 사이즈 합의 해야함.
		Dimension dS=Toolkit.getDefaultToolkit().getScreenSize(); // 윈도우 size
		Dimension dF=this.getSize(); 							// 창 size
		this.setLocation((int)((dS.getWidth()-dF.getWidth())/2),(int)((dS.getHeight()-dF.getHeight())/2)); //<======================가운데 위치 찾고	,default 창 위치 지정. 						
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
        setLayout(new GridLayout(6,2));
        JLabel label = new JLabel("Please Enter studentID and password");
        label.setFont(label.getFont().deriveFont(16.0f));
        add(label);
        add(new JLabel(""));
        
        add(new JLabel("StudentID"));
        studentID = new JTextField(10);
        add(studentID);
        add(new JLabel("Password"));
        password = new JPasswordField(10);
        add(password);
        add(new JLabel("name"));
        name = new JTextField(10);
        add(name);
        enter = new JButton("ENTER");
        add(enter);
        ButtonHandler handler = new ButtonHandler();
        enter.addActionListener(handler);
    }
    public static Student[] getStudent() {
        return Student;
    }

    public static int getCurrentStudent() {
        return currentStudent;
    }

    public static int getNumberOfRegistry() {
        return numberOfRegistry;
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            Student[numberOfRegistry] = new Student(studentID.getText(),password.getText(), name.getText());
            numberOfRegistry++;
            dispose(); 
        }
    }


}


