import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class pic2 implements Background {
	public void Back() {
		  JFrame frm = new JFrame("�׸� ���� ����");
		     ImageIcon ic  = new ImageIcon("./pic2.png");
		     JLabel lbImage1  = new JLabel(ic);		    
		     frm.add(lbImage1);
		     frm.add(lbImage1);
		     frm.setVisible(true);
		     frm.setBounds(10, 10, 800, 600);
		     frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
