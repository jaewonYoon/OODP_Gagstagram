
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/** written by jaewon Yoon 5/13 **/ 

public class slideshow extends JFrame{
	private String absolute_path;
    JLabel pic;
    Timer tm;
    int x = 0;
    int delay = 0; 
    //Images Path In Array
    public slideshow(int num){
        super("GagStagram");
        pic = new JLabel();
        pic.setBounds(40, 30, 700, 300);

        //Call The Function SetImageSize
        SetImageSize(num); // 
               //set a timer
        tm = new Timer(2000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= num )
                    x = 0; 
            }
        });
        add(pic);
        tm.start();
        setLayout(null);
        setSize(800, 400);
        getContentPane().setBackground(Color.decode("#bdb67b"));
        setLocationRelativeTo(null);
    }
    public void start() {
    		setVisible(true); 	
    }
    public void settimer(int delay) {
    		this.delay = delay; 
    }
    public int gettimer() {
    		return this.delay; 
    }
    //create a function to resize the image 
    public void setImgPath() {
    	if(Filechooser.path_saved!=null) 
        	absolute_path = Filechooser.path_saved; 
    }
    //"C:\\Users\\Indiaprince\\Desktop\\OODP\\Project2\\Pic\\"+i+".jpg"
    public void SetImageSize(int i){
		PIctureSet pictureSet = new PIctureSet(i);
		setImgPath();
		for(int j = 0 ; j <i; j++) {
			pictureSet.addPicture(new Picture(absolute_path+"/"+i+".jpg")); 
		}
		Iterator it =pictureSet.iterator();
		while(it.hasNext()) {
		Picture picture = (Picture)it.next();
        ImageIcon icon = new ImageIcon(picture.getName());
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
		}
    }
  
}
