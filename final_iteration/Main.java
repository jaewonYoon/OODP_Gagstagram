import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
    	Login aaa = new Login();
        aaa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aaa.setSize(500,500);		
		Dimension dS=Toolkit.getDefaultToolkit().getScreenSize(); // 윈도우 size
		Dimension dF=aaa.getSize(); 							// 창 size
		aaa.setLocation((int)((dS.getWidth()-dF.getWidth())/2),(int)((dS.getHeight()-dF.getHeight())/2)); //<======================가운데 위치 찾고	,default 창 위치 지정. 						
		aaa.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
        aaa.setVisible(true);

        
        
    }
}
