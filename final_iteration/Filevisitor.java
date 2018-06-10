import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Filevisitor implements Visitor {
	private String filetype;
	private ArrayList jpgfiles = new ArrayList();
	public Filevisitor(String filetype) {
		this.filetype =filetype;
	}
	public java.util.Iterator getfiles() {
		return jpgfiles.iterator();
	}
	
	@Override
	public void visit(visitorFile file) {
		// TODO Auto-generated method stub
		file.update_path(); // load the path to save the files 
		File path =new File(file.getPath()); // 
		System.out.println("현재의 패스: "+ file.getPath());
		File[] allFiles = path.listFiles();
		for(File afile :allFiles) {
		if(afile.getName().endsWith(filetype)) {
			jpgfiles.add(afile);
		}
	  }
	}
}
