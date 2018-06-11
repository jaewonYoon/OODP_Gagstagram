import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class pic3 implements Background {
	public void Back() {
		  JFrame frm = new JFrame("그림 보기 예제");
		     ImageIcon ic  = new ImageIcon("./pic3.png");
		     JLabel lbImage1  = new JLabel(ic);		    
		     frm.add(lbImage1);
		     frm.add(lbImage1);
		     frm.setVisible(true);
		     frm.setBounds(10, 10, 800, 600);
		     frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
