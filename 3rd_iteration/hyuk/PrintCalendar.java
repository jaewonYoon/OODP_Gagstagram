import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.JButton;
import javax.swing.JFrame;

public class PrintCalendar {
	public void print(int year, int month) {	
    	Calendar cal = new Calendar();
		JFrame jFrame = new JFrame(year+"년 "+month+"월");
    	JButton [] btn = new JButton [35];
    	int count = 0;
        
        jFrame.setLayout(new GridLayout(5,7));
        Container container = jFrame.getContentPane();
        
        for (int i = 1; i < cal.getNumberOfDaysInMonth(year,month)+1 ; i++) {
            if (i < 2) {
                for (int y = 1; y < cal.getStartDay(year,month)+1 ; y++) {
                	System.out.println(i+ " " +y);
                	btn[y] = new JButton("");
                	container.add(btn[y]);
                	MyMouseListener listener = new MyMouseListener();
                	btn[y].addMouseListener(listener);                	
                	count++;
                }
            }
            btn[i] = new JButton(i+"");
			container.add(btn[i]);
			if(count%7 == 0)
				btn[i].setForeground(Color.red);
			if(count%7 == 6)
				btn[i].setForeground(Color.BLUE);
			count++;
        }
        
        jFrame.setSize(600,600);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class MyMouseListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
	        CalendarMemo.memo();
	    }
		public void mouseEntered(MouseEvent e) {}
	    public void mouseExited(MouseEvent e) {}
	    public void mousePressed(MouseEvent e) {}
	    public void mouseReleased(MouseEvent e) {}	    
	}

}

	
