import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class PictureChoose extends JFrame{
	public static String address; 
	public PictureChoose() {
	Dimension dim = new Dimension(500,1000);
	JFrame frame= new JFrame("address input");
	frame.setLocation(200,400);
	
	JTextField textfield = new JTextField();
	JLabel label = new JLabel("주소입력");
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setVerticalAlignment(SwingConstants.CENTER);

	JButton button = new JButton("OK");
	JButton done = new JButton("Done");
	
	button.addActionListener(new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			address = textfield.getText();
			System.out.println(address);
		}
	});
	done.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				imageSave.getinstanceof().seturl(address);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			imageSave.getinstanceof().saveimage();
			dispose();
		}
	});
	frame.add(textfield,BorderLayout.CENTER);
	frame.add(label, BorderLayout.NORTH);
	frame.add(button, BorderLayout.SOUTH);
	frame.add(done, BorderLayout.EAST);
	frame.pack();
	frame.setVisible(true);
	    }

	public static void main(String[] args) {
		new PictureChoose();
	}

}


