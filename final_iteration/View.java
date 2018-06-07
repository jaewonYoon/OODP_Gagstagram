

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class View extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton Album;
    private JButton Posting;
    private JButton Calender;
    private JButton PS;
    private String userName;
	RemoteControl remote=new RemoteControl();
    public View() {
    	super("Menu");
    }
    public void on() {
        setVisible(true);
		this.setSize(600,200);						//<=============================�� ���� ������ ���� �ؾ���.
		Dimension dS=Toolkit.getDefaultToolkit().getScreenSize(); // ������ size
		Dimension dF=this.getSize(); 							// â size
		this.setLocation((int)((dS.getWidth()-dF.getWidth())/2),(int)((dS.getHeight()-dF.getHeight())/2)); 		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
    }
    public void off() {
    	setVisible(false);
    }
    public void makeBasicView(String userName) {
    	setResizable(false);
        this.userName = userName;
        setLayout(new GridLayout(1,4));
        //��ư�� ���
        Posting = new JButton("Posting");
        add(Posting);
        Album = new JButton("Album");
        add(Album);
        Calender = new JButton("Calender");
        add(Calender);
        PS = new JButton("Picture Select");
        add(PS);
        ButtonHandler handler = new ButtonHandler();
        Posting.addActionListener(handler);
        Album.addActionListener(handler);
        Calender.addActionListener(handler);
        PS.addActionListener(handler);
}
    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {            //instance �ϳ� �����س����� �޴��� ���ƿ����� �ٽ� â�� ���̰� �� �� ����������?
        	Object e=event.getSource();
            if(e== Posting){
            	Post p=new Post();
        		p.setVisible(true);
                PostOnCommand PostOn=new PostOnCommand(p);
                remote.setCommand(1, PostOn);
                remote.OnButtonPressed(1);
        		Post.load();
        		Post.post();
        		
            }
            else if(e == Album){
            	slideshow s=new slideshow(10);
            	s.start();
            }
            else if(e== Calender){
            	Calendar c=new Calendar();
            }
            else if(e == PS){
                Filechooser singletonfile=Filechooser.getinstance();
                singletonfile.createAndShowGUI();
            }
        }
    }
}
