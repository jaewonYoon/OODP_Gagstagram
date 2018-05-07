
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AS01_D extends Dialog implements ActionListener{
	private 
	Label lb1=new Label("글쓰기",Label.CENTER);
	Label lb2=new Label("	글쓰기");
	Label lb3=new Label("	작성자");
	//Label lb4=new Label("첨부파일");
	TextArea ta=new TextArea("",20, 60, TextArea.SCROLLBARS_VERTICAL_ONLY);
	//Button btn1=new Button("찾아보기");
	Button btn2=new Button("등록");
	Button btn3=new Button("취소");
	TextField tf1=new TextField();
	TextField tf2=new TextField();
	TextField tf3=new TextField();
	public AS01_D(Frame owner, boolean modal) {
		super(owner, modal);
		init();
		start();
		this.pack();
		Dimension dS=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dF=this.getSize();
		int x =(int)((dS.getWidth()-dF.getWidth())/2);
		int y =(int)((dS.getHeight()-dF.getHeight())/2);
		this.setLocation(x,y);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	setResizable(false);
	}
	public AS01_D(Frame owner, boolean modal, AS01_W dat) {
		this(owner,modal);
		tf1.setText(dat.getTitle());
		tf2.setText(dat.getWriter());
		//tf3.setText(dat.getFile());
		ta.setText(dat.getWriting());	
	}
	public void init() {
		BorderLayout b=new BorderLayout();
		this.setLayout(b);
		this.add("North", lb1);
		
		Panel p=new Panel(new BorderLayout());
		Panel p1=new Panel(new GridLayout(3,1,3,3));
		Panel p2 = new Panel(new BorderLayout());
		p2.add("West",lb2);
		p2.add("Center",tf1);
		p1.add(p2);
		Panel p3=new Panel(new BorderLayout());
		p3.add("West",lb3);
		p3.add("Center",tf2);
		p1.add(p3);
		Panel p4=new Panel(new BorderLayout());
		//p4.add("West",lb4);
		p4.add("Center",tf3);
		//p4.add("East",btn1);
		p1.add(p4);
		p.add("North",p1);
		p.add("Center",ta);
		Panel p5=new Panel(new CardLayout(5,10));
		Panel p6=new Panel(new FlowLayout(FlowLayout.RIGHT));
		p6.add(btn2);
		p6.add(btn3);
		p5.add(p6);
		p.add("South",p5);
		this.add(p);
		
		tf3.setEditable(false);
	}
	public void start() {
		//btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		/*if(o==btn1) {
			FileDialog f=new FileDialog(this);
			f.setTitle("파일 찾아보기");
			f.setVisible(true);
			tf3.setText(f.getDirectory()+f.getFile());
		}
		*/
		if(o==btn2) {
			String t=tf1.getText();
			String n=tf2.getText();
			String f=tf3.getText();
			String c=ta.getText();
			AS01_W obj=new AS01_W(n,t,c,f);
			AS01.data.add(obj);
			AS01.save();
			AS01.post();
			setVisible(false);
		}
		else if(o==btn3) {
			this.setVisible(false);
		}
	}
}