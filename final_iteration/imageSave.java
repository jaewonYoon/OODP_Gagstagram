import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
public class imageSave {
	private static imageSave imagesaver = new imageSave(); 

	public String output;
	private static int piccount = 0; 
	public String seturl; 
	private URL url; 
 public void seturl(String seturl) throws MalformedURLException {
	 url = new URL(seturl); 
	 this.seturl = seturl;
 }
public void setcount(){
	piccount++;
}
public static int getpiccount() {
	return piccount; 
}
public void saveimage() {
	piccount = 0; 
	visitorFile samplefile = new visitorFile("something",""); 
	Filevisitor filevisitor = new Filevisitor(".jpg");
	samplefile.accept(filevisitor);
	//filevisitor.visit(samplefile); // filevisitor 의 jpgfiles에다가 저장함. 
	java.util.Iterator it = filevisitor.getfiles();
	while(it.hasNext()) { //총 사진  몇 장 있는지 세기  
		piccount++;
		File file = (File) it.next();
		System.out.println(file.toString());
	}
	if(seturl==null) {
		output ="no url set!"; 
		System.out.println(output);
	}
	else {
		try {
			BufferedImage img = ImageIO.read(url);
			System.out.println(piccount);
			File file = new File(samplefile.getPath()+"/"+(piccount+1)+".jpg");
			ImageIO.write(img, "jpg", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}    
}

public static imageSave getinstanceof() { //싱글톤 디자인 패턴 적용 
	if(imagesaver==null)
		imagesaver = new imageSave();
	return imagesaver;
}
}