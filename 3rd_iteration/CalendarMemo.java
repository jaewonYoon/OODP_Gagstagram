import javax.swing.*;

public class CalendarMemo {
	public static void memo() {                    
        
        JFrame f = new JFrame();
        f.setSize(350,250);  
        JTextArea t = new JTextArea();        
        f.add(t);
        JButton btn1 = new JButton("����");
        //JButton btn2 = new JButton("���");
        f.add(btn1, "South");
        //f.add(btn2, "South");
        f.setLocation(600,0);
        f.setVisible(true);
    }       
}
