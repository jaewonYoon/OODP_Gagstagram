
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AS01 {

	public static void main(String[] args) {
		AS01F r=new AS01F();
		r.setVisible(true);
		AS01F.load();
		AS01F.post();

	}
}

class AS01F extends Frame implements ActionListener, ItemListener{
	private final static File F= new File("");
	
	//Frame 
	private 
	Label list=new Label("글목록");
	Label view=new Label("글보기");
	static List liF=new List(15);
	TextArea taF=new TextArea();
	Button b1=new Button("글쓰기");
	Button b2=new Button("새로고침");
	Button b3=new Button("수정");
	Button b4=new Button("삭제");
	Button b5=new Button("종료");
	static ArrayList<AS01_W> data=new ArrayList<AS01_W>();
	public AS01F() {
		super("게시판");
		init();
		start();
		this.setSize(800,600);
		Dimension dS=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dF=this.getSize();
		int x =(int)((dS.getWidth()-dF.getWidth())/2);
		int y =(int)((dS.getHeight()-dF.getHeight())/2);
		this.setLocation(x,y);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}	
	private void init() {
		taF.setEditable(false);
		GridLayout gF=new GridLayout(1,2,8,0);
		this.setLayout(gF);
		Panel p1=new Panel(new BorderLayout());
		p1.add("North",list);
		Panel p5=new Panel(new CardLayout(0,3));
		p5.add(liF);
		p1.add("Center", p5);
		Panel p2=new Panel(new GridLayout(1,2,3,3));
		p2.add(b1);
		p2.add(b2);
		p1.add("South",p2);
		this.add(p1);
		
		Panel p3=new Panel(new BorderLayout());
		p3.add("North",view);
		Panel p6=new Panel(new CardLayout(0,3));
		p6.add(taF);
		p3.add("Center",p6);
		Panel p4=new Panel(new GridLayout(1,3,3,3));
		p4.add(b3);
		p4.add(b4);
		p4.add(b5);
		p3.add("South",p4);
		this.add(p3);
	}
	private void start() {
		liF.addItemListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o==b1) {
			 AS01_D d=new AS01_D(this, true);
			 d.setVisible(true);
		}
		else if(o==b2){
			int i=liF.getSelectedIndex();
			load();
			post();
			taF.setText("");
			liF.select(i);
		}

		else if(o==b3){
			int i=liF.getSelectedIndex();
			if(i>=0) {
				AS01_D d=new AS01_D(this, true, data.get(i));
				data.remove(i);
				d.setVisible(true);
						
			}
		}

		else if(o==b4){
			int i=liF.getSelectedIndex();
			if(i>=0) {
				data.remove(i);
			}
			save();
			post();
			if(liF.getItemCount()>0) {
				liF.select(0);
			}
		}
		else if(o==b5){
			System.exit(0);
		}
	}
	public void itemStateChanged(ItemEvent e) {
		int i=liF.getSelectedIndex();
		AS01_W o=data.get(i);
		String str;
		str="글제목 : "+o.getTitle()+"\n\n"+"작성자 : "+o.getWriter()+"\n\n";
		//str="글제목 : "+o.getTitle()+"\n\n"+"작성자 : "+o.getWriter()+"\n\n"+"첨부파일 : "+o.getFile()+"\n\n"+o.getWriting();
		taF.setText(str);
	}
	public static void post() {
		int I=data.size();
		AS01_W temp;
		liF.removeAll();
		for(int i=0;i<I;i++) {
			temp=data.get(i);
			liF.add(String.valueOf(i+1)+"."+temp.getTitle()+"("+temp.getWriter()+")");
		}
	}
	public static void save() {
		ObjectOutputStream oos=null;
		try {
			oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(F)));
			oos.writeObject(data);
			oos.close();
		}catch(IOException e){}
	}
	public static void load() {
		ObjectInputStream ois=null;
		Object o1=null;
		try {
			ois =new ObjectInputStream(new BufferedInputStream(new FileInputStream(F)));
			o1=ois.readObject();
			ois.close();
			//data=(ArrayList<AS01_W>)o1;
		}catch(FileNotFoundException e1) {
			System.out.println("fnfe");
		}catch(IOException e2) {
			System.out.println("io");
		}catch(ClassNotFoundException e3) {
			System.out.println("cnfe");
		}
	}
}












