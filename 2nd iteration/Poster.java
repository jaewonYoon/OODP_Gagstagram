
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
import javax.swing.JOptionPane;

public class Poster {
	public static void main(String[] args) {
		PostF p=new PostF();
		p.setVisible(true);
		PostF.load();
		PostF.post();

	}
}
class PostF extends Frame implements ActionListener, ItemListener{
	private static final long serialVersionUID = 1L;
	private final static File F= new File("");
	private 

	
	Label list=new Label("글목록");
	Label view=new Label("글보기");
	static List liF=new List(15);  //<-----------------------------------------------리스트
	TextArea taF=new TextArea();
	//Button b1=new Button("글쓰기");
	//Button b2=new Button("새로고침");
	//Button b3=new Button("수정");
	//Button b4=new Button("삭제");
	//Button b5=new Button("종료");
	static ArrayList<Serial> data=new ArrayList<Serial>(); 
	public
	String[] message= {"글쓰기","수정","삭제","종료"};
	Button[] bn=new Button[message.length];
	Button_set b=new Button_set(4);

	//<-----------------------------어레이리스트
	public PostF() {
		super("GagStarGram");
		init();
		start();
		this.setSize(800,600);						//<=============================다 같이 사이즈 합의 해야함.
		Dimension dS=Toolkit.getDefaultToolkit().getScreenSize(); // 윈도우 size
		Dimension dF=this.getSize(); 							// 창 size
		this.setLocation((int)((dS.getWidth()-dF.getWidth())/2),(int)((dS.getHeight()-dF.getHeight())/2)); //<======================가운데 위치 찾고	,default 창 위치 지정. 						
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}	

	//==============================================================
	private void init() {
		for(int i=0;i<message.length;i++) {
			b.appendButton(new But(message[i]));
		}
		Iterator i=b.iterator();
		int c=0;
		while(i.hasNext()) {
			But bp=(But)i.next();
			bn[c]=new Button(bp.getName());
			c++;
		}
		taF.setEditable(false);
		GridLayout gF=new GridLayout(1,2,8,0);  					//<-----------------(1,2)  ㅁㅁ  이렇게 있어서 가로 gap은 가능하지만 세로 gap x
		this.setLayout(gF);    										//<========    visualize
		Panel p1=new Panel(new BorderLayout());
		p1.add("North",list);										// <=========위에 판넬
		Panel p5=new Panel(new CardLayout(0,3));					 // 패널 iterator design pattern 사용하자.
		p5.add(liF);
		p1.add("Center", p5);
		Panel p2=new Panel(new GridLayout(1,1,3,3));					//버튼 색도 iterator design pattern으로 가능
		p2.add(bn[0]);
		//p2.add(b2);
		p1.add("South",p2);												//전체적으로 init부분은 iterator 로 간략화 가능.
		this.add(p1);
		
		Panel p3=new Panel(new BorderLayout());
		p3.add("North",view);
		Panel p6=new Panel(new CardLayout(0,3));
		p6.add(taF);
		p3.add("Center",p6);
		Panel p4=new Panel(new GridLayout(1,3,3,3));
		p4.add(bn[1]);
		p4.add(bn[2]);
		p4.add(bn[3]);
		p3.add("South",p4);
		this.add(p3);
		
		
		
		
		
	}
	//=====================================================================
	private void start() {
		liF.addItemListener(this);
		bn[0].addActionListener(this);
		//b2.addActionListener(this);
		bn[1].addActionListener(this);
		bn[2].addActionListener(this);
		bn[3].addActionListener(this);

	}
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o==bn[0]) {
			 Writer d=new Writer(this, true);
			 d.setVisible(true);
		}
		/*else if(o==b2){
			int i=liF.getSelectedIndex();
			load();
			post();
			taF.setText("");
			liF.select(i);
		}*/

		else if(o==bn[1]){
			int i=liF.getSelectedIndex();
			if(i>=0) {
				Writer d=new Writer(this, true, data.get(i));
				data.remove(i);
				d.setVisible(true);
						
			}
		}

		else if(o==bn[2]){
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
		else if(o==bn[3]){
			System.exit(0);
		} 	
	}
	public void itemStateChanged(ItemEvent e) {
		int i=liF.getSelectedIndex();
		Serial o=data.get(i);
		String str;
		str="글제목 : "+o.getTitle()+"\n\n"+"작성자 : "+o.getWriter()+"\n\n"+"첨부파일 : "+o.getFile()+"\n\n"+o.getWriting();
		taF.setText(str);
	}
	public static void post() {
		int I=data.size();
		Serial temp;
		liF.removeAll();
		for(int i=0;i<I;i++) {
			temp=data.get(i);
			liF.add(String.valueOf(i+1)+"."+temp.getTitle()+"("+temp.getWriter()+")");
		}
	}
	public static void save() {
		FileOutputStream fos = null;
		ObjectOutputStream oos=null;
		try {
			fos=new FileOutputStream(F);
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			oos=new ObjectOutputStream(bos);
			oos.writeObject(data);
			oos.flush();
			JOptionPane.showMessageDialog(null, "저장되었습니다.");
			oos.close();
		}catch(IOException e){

		}finally{
			
			// 스트림을 닫아준다.
			if(fos != null) try{fos.close();}catch(IOException e){}
			if(oos != null) try{oos.close();}catch(IOException e){}	
		}
	}


	public static void load() {
		ObjectInputStream ois=null;
		Object o1=null;
		try {
			ois =new ObjectInputStream(new BufferedInputStream(new FileInputStream(F)));
			o1=ois.readObject();
			ois.close();
			data=(ArrayList<Serial>)o1;
		}catch(FileNotFoundException e1) {
			System.out.println("파일 못 찾는 오류");
		}catch(IOException e2) {
			System.out.println("입출력 오류");
		}catch(ClassNotFoundException e3) {
			System.out.println("클라스 못 찾는 오류");
		}
	}
}








